class Solution {
  public int equalSubstring(String s, String t, int maxCost) {
    int n = s.length();
    int left = 0;
    int right = 0;
    int currentCost = 0;
    int maxLength = 0;

    char[] sCharacters = s.toCharArray();
    char[] tCharacters = t.toCharArray();

    while (right < n) {
      currentCost += Math.abs(sCharacters[right] - tCharacters[right]);

      while (currentCost > maxCost) {
        currentCost -= Math.abs(sCharacters[left] - tCharacters[left]);
        left++;
      }

      maxLength = Math.max(maxLength, right - left + 1);
      right++;
    }

    return maxLength;
  }
}

class Solution {
  public int characterReplacement(String s, int k) {
    int left = 0;
    int[] count = new int[26];
    int maxOccurance = 0;
    int longestRepeatingLength = 0;
    int n = s.length();
    char[] characters = s.toCharArray();

    for (int right = 0; right < n; right++) {
      count[characters[right] - 'A']++;
      maxOccurance = Math.max(maxOccurance, count[characters[right] - 'A']);

      if ((right - left + 1) - maxOccurance > k) {
        count[characters[left] - 'A']--;
        left++;
      }

      longestRepeatingLength = (right - left + 1);
    }

    return longestRepeatingLength;
  }
}

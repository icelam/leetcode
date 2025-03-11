class Solution {
  public int numberOfSubstrings(String s) {
    int n = s.length();
    char[] characters = s.toCharArray();
    int left = 0;
    int right = 0;
    int[] frequency = new int[3];
    int result = 0;

    while (right < n) {
      frequency[characters[right] - 'a']++;

      while (frequency[0] >= 1 && frequency[1] >= 1 && frequency[2] >= 1) {
        result += n - right;
        frequency[characters[left] - 'a']--;
        left++;
      }

      right++;
    }

    return result;
  }
}

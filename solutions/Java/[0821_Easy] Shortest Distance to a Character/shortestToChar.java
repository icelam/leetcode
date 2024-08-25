class Solution {
  public int[] shortestToChar(String s, char c) {
    char[] characters = s.toCharArray();
    int n = characters.length;
    int[] result = new int[n];

    int left = -1;
    int right = -1;

    while (right < n) {
      right = left + 1;

      while (right < n && characters[right] != c) {
        right++;
      }

      for (int j = left + 1; j < right; j++) {
        if (left == -1) {
          result[j] = right - j;
        } else if (right == n) {
          result[j] = j - left;
        } else {
          result[j] = Math.min(j - left, right - j);
        }
      }

      left = right;
    }

    return result;
  }
}

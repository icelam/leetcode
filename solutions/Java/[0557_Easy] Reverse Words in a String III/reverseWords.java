class Solution {
  public String reverseWords(String s) {
    int n = s.length();
    int left = 0;
    int right = 0;
    char[] result = s.toCharArray();

    while (right < n) {
      for (int i = left; i < n && result[i] != ' '; i++) {
        right = i;
      }

      for (int j = left, k = right; j < k; j++, k--) {
        char temp = result[j];
        result[j] = result[k];
        result[k] = temp;
      }

      left = right + 2;
      right = right + 2;
    }

    return new String(result);
  }
}

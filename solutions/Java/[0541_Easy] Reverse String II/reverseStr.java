class Solution {
  private void reverse(char[] characters, int start, int end) {
    int n = end - start + 1;

    for (int i = 0; i < n / 2; i++) {
      char temp = characters[start + i];
      characters[start + i] = characters[end - i];
      characters[end - i] = temp;
    }
  }

  public String reverseStr(String s, int k) {
    char[] characters = s.toCharArray();
    int n = characters.length;

    for (int i = 0; i < n; i += k * 2) {
      reverse(characters, i, Math.min(n - 1, i + k - 1));
    }

    return new String(characters);
  }
}

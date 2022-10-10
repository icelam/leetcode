class Solution {
  public String breakPalindrome(String palindrome) {
    int length = palindrome.length();
    if (length <= 1) {
      return "";
    }

    char[] c = palindrome.toCharArray();

    for (int i = 0; i < length / 2; i++) {
      if (c[i] != 'a') {
        c[i] = 'a';
        return new String(c);
      }
    }

    c[length - 1] = 'b';
    return new String(c);
  }
}

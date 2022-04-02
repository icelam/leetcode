class Solution {
  public boolean isPalindrome(String s, int start, int end) {
    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) {
        return false;
      }

      start++;
      end--;
    }

    return true;
  }

  public boolean validPalindrome(String s) {
    for (int i = 0; i < s.length() / 2; i++) {
      if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
        return (
          isPalindrome(s, i + 1, s.length() - 1 - i)
          || isPalindrome(s, i, s.length() - 1 - i - 1)
        );
      }
    }

    return true;
  }
}

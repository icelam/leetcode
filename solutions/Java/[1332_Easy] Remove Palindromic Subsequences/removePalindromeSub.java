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

  public int removePalindromeSub(String s) {
    // If the string is palindrome, then it can always be removed with 1 move,
    // else we just need to delete all the a first and remove all b,
    // since "a subsequence does not necessarily need to be contiguous"
    return isPalindrome(s, 0, s.length() - 1) ? 1 : 2;
  }
}

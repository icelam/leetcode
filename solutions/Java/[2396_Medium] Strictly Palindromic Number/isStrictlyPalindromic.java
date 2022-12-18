class Solution {
  public boolean isStrictlyPalindromic(int n) {
    // Constraint: n >= 4
    // Case 1: n == 4, the only base 2, which is (n - 2), will be 100, not palindrome
    // Case 2: n >= 5, base n - 2 will always be 12, not palindrome
    return false;
  }
}

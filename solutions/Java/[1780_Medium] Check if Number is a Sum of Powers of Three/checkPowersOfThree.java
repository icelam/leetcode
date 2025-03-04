class Solution {
  public boolean checkPowersOfThree(int n) {
    while (n != 0) {
      // If we pay attention to the question, you will find that the problem can be converted to
      // ternary numeral system (base 3 or Trinary). We can divide n by 3 and take the remainder.
      // If we get 0 or 1, it means that the ternary system is satisfied, and so on,
      // until the division is completed. If the remainder is not 0 or 1 during division by 3,
      // false is returned directly.
      //
      // Example:
      // Trinary 1 1 0 1 represents 1 * 3^3 + 1 * 3^2 + 0 * 3^1 + 1
      // Trinary 2 1 0 1 represents 2 * 3^3 + 1 * 3^2 + 0 * 3^1 + 1
      // If there happens to have 2 "3^3", it doesn't satisfies requirement of
      if (n % 3 == 2) {
        return false;
      }

      n = n / 3;
    }

    return true;
  }
}

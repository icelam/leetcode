class Solution {
  private int reverse(int num) {
    int result = 0;

    while (num != 0) {
      int digit = num % 10;
      result = result * 10 + digit;
      num /= 10;
    }

    return result;
  }

  public boolean isSameAfterReversals(int num) {
    return reverse(reverse(num)) == num;
  }
}

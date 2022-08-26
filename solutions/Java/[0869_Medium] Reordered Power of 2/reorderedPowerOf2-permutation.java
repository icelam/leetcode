class Solution {
  private int[] intToArray(int n) {
    int length = (int) (Math.log10(n) + 1);
    int[] digits = new int[length];

    int i = 0;

    while (n > 0) {
      digits[i] = n % 10;
      n /= 10;
      i++;
    }

    return digits;
  }

  private int arrayToInt(int[] digits) {
    int n = 0;

    for (int digit: digits) {
      n *= 10;
      n += digit;
    }

    return n;
  }

  private boolean isPowerOfTwo(int n) {
    return n > 0 && (n & (n - 1)) == 0;
  }

  private void swap(int[] digits, int left, int right) {
    if (left == right) {
      return;
    }

    int temp = digits[left];
    digits[left] = digits[right];
    digits[right] = temp;
  }

  private boolean generate(int[] digits, int left, int right) {
    if (left == right) {
      if (digits[0] == 0) {
        return false;
      }

      int n = arrayToInt(digits);
      return isPowerOfTwo(n);
    }

    for (int i = left; i <= right; i++) {
      swap(digits, left, i);

      if (generate(digits, left + 1, right)) {
        return true;
      }

      swap(digits, left, i);
    }

    return false;
  }

  public boolean reorderedPowerOf2(int n) {
    int[] digits = intToArray(n);
    return generate(digits, 0, digits.length - 1);
  }
}

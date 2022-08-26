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

  private boolean isArrayEqual(int[] a1, int[] a2) {
    if (a1.length != a2.length) {
      return false;
    }

    for (int i = 0; i < a1.length; i++) {
      if (a1[i] != a2[i]) {
        return false;
      }
    }

    return true;
  }

  public boolean reorderedPowerOf2(int n) {
    int maxBits = (int) (Math.log(10e8) / Math.log(2) + 1);

    int[] digitsOfN = intToArray(n);
    Arrays.sort(digitsOfN);

    for (int i = 0; i < maxBits; i++) {
      int[] digitsOfPowerOfTwo = intToArray(1 << i);
      Arrays.sort(digitsOfPowerOfTwo);

      if (isArrayEqual(digitsOfN, digitsOfPowerOfTwo)) {
        return true;
      }
    }

    return false;
  }
}

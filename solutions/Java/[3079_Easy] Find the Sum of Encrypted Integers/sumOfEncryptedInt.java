class Solution {
  private int encrypt(int n) {
    int maxDigit = 0;
    int result = 0;
    int temp = n;

    while (temp > 0) {
      maxDigit = Math.max(maxDigit, temp % 10);
      temp /= 10;
      result = result * 10 + 1;
    }

    return result * maxDigit;
  }

  public int sumOfEncryptedInt(int[] nums) {
    int result = 0;

    for (int value: nums) {
      result += encrypt(value);
    }

    return result;
  }
}

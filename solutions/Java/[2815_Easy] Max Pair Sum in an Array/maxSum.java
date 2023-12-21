class Solution {
  public int maxSum(int[] nums) {
    int result = -1;
    int[] maxDigitBucket = new int[10];

    Arrays.fill(maxDigitBucket, Integer.MIN_VALUE);

    for (int currentNum: nums) {
      int currentMaxDigit = 0;

      for (int n = currentNum; n > 0; n /= 10) {
        currentMaxDigit = Math.max(currentMaxDigit, n % 10);
      }

      result = Math.max(result, currentNum + maxDigitBucket[currentMaxDigit]);
      maxDigitBucket[currentMaxDigit] = Math.max(maxDigitBucket[currentMaxDigit], currentNum);
    }

    return result;
  }
}

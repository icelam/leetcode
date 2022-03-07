class Solution {
  public int sumOddLengthSubarrays(int[] arr) {
    int windowSize = 1;
    int sum = 0;

    while (windowSize <= arr.length) {
      int windowSum = 0;

      for (int i = 0; i < arr.length; i++) {
        windowSum += arr[i];

        if (i > windowSize - 1) {
          windowSum -= arr[i - windowSize];
        }

        if (i >= windowSize - 1) {
          sum += windowSum;
        }
      }

      windowSize += 2;
    }

    return sum;
  }
}

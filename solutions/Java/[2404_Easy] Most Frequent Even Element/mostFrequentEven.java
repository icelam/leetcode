class Solution {
  public int mostFrequentEven(int[] nums) {
    int[] frequency = new int[100001];
    int maxNum = 0;

    for (int n: nums) {
      if (n % 2 == 0) {
        frequency[n]++;
        maxNum = Math.max(maxNum, n);
      }
    }

    int maxFrequency = Integer.MIN_VALUE;
    int result = Integer.MAX_VALUE;

    for (int i = 0; i <= maxNum; i += 2) {
      int currentFrequency = frequency[i];

      if (currentFrequency == 0) {
        continue;
      }

      if (maxFrequency == currentFrequency && i < result) {
        result = i;
      } else if (currentFrequency > maxFrequency) {
        result = i;
        maxFrequency = currentFrequency;
      }
    }

    return result == Integer.MAX_VALUE ? -1 : result;
  }
}

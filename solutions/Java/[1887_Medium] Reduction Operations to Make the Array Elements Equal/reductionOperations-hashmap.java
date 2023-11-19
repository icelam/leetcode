class Solution {
  public int reductionOperations(int[] nums) {
    int n = nums.length;
    int[] frequency = new int[50001];
    int minValue = Integer.MAX_VALUE;
    int maxValue = Integer.MIN_VALUE;

    for (int num: nums) {
      frequency[num]++;
      minValue = Math.min(minValue, num);
      maxValue = Math.max(maxValue, num);
    }

    int operationCount = 0;
    int largestNumCount = 0;

    for (int i = maxValue; i > minValue; i--) {
      if (frequency[i] != 0) {
        largestNumCount += frequency[i];
        operationCount += largestNumCount;
      }
    }

    return operationCount;
  }
}

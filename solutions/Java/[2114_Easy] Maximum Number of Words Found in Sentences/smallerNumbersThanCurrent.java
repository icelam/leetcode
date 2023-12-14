class Solution {
  public int[] smallerNumbersThanCurrent(int[] nums) {
    int n = nums.length;
    int[] prefixSum = new int[501];

    for (int num: nums) {
      prefixSum[num]++;
    }

    for (int i = 1; i < 501; i++) {
      prefixSum[i] += prefixSum[i - 1];
    }

    int[] result = new int[n];

    for (int i = 0; i < n; i++) {
      if (nums[i] == 0) {
        result[i] = 0;
      } else {
        result[i] = prefixSum[nums[i] - 1];
      }
    }

    return result;
  }
}

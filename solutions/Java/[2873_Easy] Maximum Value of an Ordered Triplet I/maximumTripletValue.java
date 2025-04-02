class Solution {
  public long maximumTripletValue(int[] nums) {
    int n = nums.length;
    long max = Long.MIN_VALUE;

    for (int i = 0; i < n - 2; i++) {
      for (int j = i + 1; j < n - 1; j++) {
        for (int k = j + 1; k < n; k++) {
          max = Math.max(max, ((long) nums[i] - nums[j]) * nums[k]);
        }
      }
    }

    if (max < 0) {
      return 0;
    }

    return max;
  }
}

class Solution {
  public double minimumAverage(int[] nums) {
    int n = nums.length;
    int m = n / 2;
    double minAverage = 51;

    Arrays.sort(nums);

    for (int i = 0, j = n - 1; i < m; i++, j--) {
      minAverage = Math.min(minAverage, ((double) nums[i] + nums[j]) / 2);
    }

    return minAverage;
  }
}

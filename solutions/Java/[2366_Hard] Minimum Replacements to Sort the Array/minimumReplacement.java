class Solution {
  public long minimumReplacement(int[] nums) {
    int n = nums.length;
    long totalReplaceCount = 0;
    int max = nums[n - 1];

    for (int i = n - 2; i >= 0; i--) {
      int replaceCount = (nums[i] - 1) / max;
      totalReplaceCount += replaceCount;
      max = nums[i] / (replaceCount + 1);
    }

    return totalReplaceCount;
  }
}

class Solution {
  public int distinctAverages(int[] nums) {
    int n = nums.length;
    boolean[] isSeen = new boolean[201];
    int result = 0;

    Arrays.sort(nums);

    for (int left = 0, right = n - 1; left < right; left++, right--) {
      int sum = nums[left] + nums[right];

      if (!isSeen[sum]) {
        result++;
      }

      isSeen[sum] = true;
    }

    return result;
  }
}

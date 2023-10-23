class Solution {
  public int maximumScore(int[] nums, int k) {
    int left = k;
    int right = k;
    int n = nums.length;
    int result = 0;

    for (int i = nums[k]; left >= 0 || right < n; i--) {
      while (right < n && nums[right] >= i) {
        right++;
      }

      while (left >= 0 && nums[left] >= i) {
        left--;
      }

      result = Math.max(result, (right - left - 1) * i);
    }

    return result;
  }
}

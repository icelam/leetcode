class Solution {
  public int longestOnes(int[] nums, int k) {
    int n = nums.length;
    int left = 0;
    int right = 0;
    int flips = 0;
    int result = 0;

    while (right < n) {
      if (nums[right] == 0) {
        flips++;
      }

      while (flips > k) {
        if (nums[left] == 0) {
          flips--;
        }

        left++;
      }

      result = Math.max(result, right - left + 1);
      right++;
    }

    return result;
  }
}

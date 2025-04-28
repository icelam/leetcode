class Solution {
  public long countSubarrays(int[] nums, long k) {
    long result = 0;
    long sum = 0;
    int left = 0;
    int right = 0;

    while (right < nums.length) {
      sum += nums[right];

      while (sum * (right - left + 1) >= k) {
        sum -= nums[left];
        left++;

      }
      result += right - left + 1;
      right++;
    }

    return result;
  }
}

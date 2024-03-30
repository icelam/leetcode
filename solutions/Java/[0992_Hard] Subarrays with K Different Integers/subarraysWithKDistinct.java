class Solution {
  public int atMostKDistinct(int[] nums, int k) {
    int n = nums.length;
    int[] frequency = new int[n + 1];
    int left = 0;
    int right = 0;
    int currentUniqueCount = 0;
    int result = 0;

    while (right < n) {
      if (frequency[nums[right]] == 0) {
        currentUniqueCount++;
      }

      frequency[nums[right]]++;

      while (currentUniqueCount > k) {
        if (frequency[nums[left]] == 1) {
          currentUniqueCount--;
        }

        frequency[nums[left]]--;
        left++;
      }

      result += right - left + 1;
      right++;
    }

    return result;
  }

  public int subarraysWithKDistinct(int[] nums, int k) {
    return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
  }
}

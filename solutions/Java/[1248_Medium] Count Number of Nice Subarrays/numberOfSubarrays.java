class Solution {
  /* This question is similar to 930. Binary Subarrays With Sum */
  public int numberOfSubarrays(int[] nums, int k) {
    int n = nums.length;
    int left = 0;
    int right = 0;
    int leadingEvenCount = 0;
    int oddCount = 0;
    int result = 0;

    while (right < n) {
      oddCount += nums[right] % 2;

      while (left < right && (oddCount > k || nums[left] % 2 == 0)) {
        if (nums[left] % 2 == 1) {
          leadingEvenCount = 0;
        } else {
          leadingEvenCount++;
        }

        oddCount -= nums[left] % 2;
        left++;
      }

      if (oddCount == k) {
        result += 1 + leadingEvenCount;
      }

      right++;
    }

    return result;
  }
}

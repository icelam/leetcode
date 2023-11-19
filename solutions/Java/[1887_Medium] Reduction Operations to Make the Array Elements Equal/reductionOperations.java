class Solution {
  public int reductionOperations(int[] nums) {
    Arrays.sort(nums);

    int n = nums.length;
    int left = n - 1;
    int right = n - 1;
    int operationCount = 0;
    int largestNumCount = 0;

    while (right >= 0) {
      // Put it at top as we don't need to include count of smallest element.
      // Same effect as putting it at the end of loop with if (left > -1)
      operationCount += largestNumCount;

      while (left >= 0 && nums[left] == nums[right]) {
        left--;
      }

      largestNumCount += right - left;
      right = left;
    }

    return operationCount;
  }
}

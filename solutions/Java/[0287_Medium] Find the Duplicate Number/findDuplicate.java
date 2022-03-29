class Solution {
  public int findDuplicate(int[] nums) {
    // It is a requirement to keep `nums` immutable and use O(1) space.
    // Pigeonhole Principle defines that n + 1 integers
    // where each integer is in the range [1, n] inclusive
    // will have at least 1 integer repeated.
    //
    // For example if n = 10, nums = [1, 5, 2, 8, 9, 2, 3, 4, 10, 7 ]
    // Idea is to perform binary search on 1 - 10, count the number of integer
    // which is less than or equal to 5 in nums.
    // If number of count is >= 5, the duplicate number is in [left, middle],
    // else it is in [middle + 1, right]. Repeat until space exhausted.
    //
    // Time Complexity: O(nlogn), Space Complexity: O(1)

    int length = nums.length;
    int left = 1;
    int right = length - 1;

    while (left < right) {
      int middle = (right + left) / 2;
      int count = 0;

      for (int i = 0; i < length; i++) {
        if (nums[i] <= middle) {
          count++;
        }
      }

      if (count <= middle) {
        left = middle + 1;
      } else {
        right = middle;
      }
    }

    return left;
  }
}

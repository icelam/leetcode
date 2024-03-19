class Solution {
  public boolean canBeIncreasing(int[] nums) {
    int n = nums.length;
    int largestNum = 0;
    int secondLargestNum = 0;
    boolean hasRemoved = false;

    for (int i = 0; i < n; i++) {
      if (nums[i] > largestNum) {
        secondLargestNum = largestNum;
        largestNum = nums[i];
        continue;
      }

      if (hasRemoved) {
        return false;
      }

      hasRemoved = true;

      if (nums[i] > secondLargestNum) {
        largestNum = nums[i];
      }
    }

    return true;
  }
}

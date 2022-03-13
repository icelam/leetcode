class Solution {
  public boolean isMonotonic(int[] nums) {
    if (nums.length == 1) {
      return true;
    }

    int result = nums[1] - nums[0];

    for (int i = 2; i < nums.length; i++) {
      int current = nums[i] - nums[i - 1];

      if ((current > 0 && result < 0) || (current < 0 && result > 0)) {
        return false;
      }

      if (current != 0) {
        result = current;
      }
    }

    return true;
  }
}

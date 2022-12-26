class Solution {
  public boolean canJump(int[] nums) {
    int maxReachableDistance = 0;

    for (int i = 0; i < nums.length; i++) {
      if (i > maxReachableDistance) {
        return false;
      }

      maxReachableDistance = Math.max(maxReachableDistance, i + nums[i]);
    }

    return true;
  }
}

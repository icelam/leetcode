class Solution {
  public boolean check(int[] nums) {
    int n = nums.length;
    boolean hasRotated = false;

    for (int i = 1; i <= n; i++) {
      if (nums[i % n] < nums[i - 1]) {
        if (hasRotated) {
          return false;
        }

        hasRotated = true;
      }
    }

    return true;
  }
}

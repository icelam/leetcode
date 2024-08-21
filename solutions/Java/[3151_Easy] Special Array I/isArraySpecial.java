class Solution {
  public boolean isArraySpecial(int[] nums) {
    int n = nums.length;
    int previousParityGroup = nums[0] % 2;

    for (int i = 1; i < n; i++) {
      if (nums[i] % 2 == previousParityGroup) {
        return false;
      }

      previousParityGroup = nums[i] % 2;
    }

    return true;
  }
}

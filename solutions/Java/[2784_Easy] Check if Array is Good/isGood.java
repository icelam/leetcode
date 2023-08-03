class Solution {
  public boolean isGood(int[] nums) {
    int length = nums.length;
    if (length < 2) {
      return false;
    }

    Arrays.sort(nums);

    if (nums[length - 1] != nums[length - 2]) {
      return false;
    }

    for (int i = 0; i < length - 1; i++) {
      if (nums[i] != i + 1) {
        return false;
      }
    }

    return true;
  }
}

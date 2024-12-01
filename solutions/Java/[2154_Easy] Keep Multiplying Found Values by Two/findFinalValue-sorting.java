class Solution {
  public int findFinalValue(int[] nums, int original) {
    Arrays.sort(nums);

    for (int value: nums) {
      if (value == original) {
        original *= 2;
      }
    }

    return original;
  }
}

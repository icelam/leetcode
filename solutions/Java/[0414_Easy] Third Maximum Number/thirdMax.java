class Solution {
  public int thirdMax(int[] nums) {
    Arrays.sort(nums);

    for (int i = nums.length - 2, distinctCount = 1; i >= 0; i--) {
      if (nums[i] != nums[i + 1]) {
        distinctCount++;
      }

      if (distinctCount == 3) {
        return nums[i];
      }
    }

    return nums[nums.length - 1];
  }
}

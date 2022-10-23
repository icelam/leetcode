class Solution {
  public int[] findErrorNums(int[] nums) {
    Arrays.sort(nums);

    int duplicateNum = -1;
    int missingNum = 1;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1]) {
        duplicateNum = nums[i - 1];
      } else if (nums[i] > nums[i - 1] + 1) {
        missingNum = nums[i - 1] + 1;
      }
    }

    return new int[] {
      duplicateNum,
      nums[nums.length - 1] != nums.length
        ? nums.length
        : missingNum
    };
  }
}

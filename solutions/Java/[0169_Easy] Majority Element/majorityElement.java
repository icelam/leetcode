class Solution {
  public int majorityElement(int[] nums) {
    Arrays.sort(nums);

    int previousNum = 0;
    int count = 0;

    for (int i = 0; i < nums.length; i++) {
      if (i == 0 || nums[i] == previousNum) {
        count++;
      } else {
        count = 1;
      }

      previousNum = nums[i];

      if (count > nums.length / 2) {
        break;
      }
    }

    return previousNum;
  }
}

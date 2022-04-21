class Solution {
  public int missingNumber(int[] nums) {
    int accumulator = 0;

    for (int i = 0; i < nums.length; i++) {
      accumulator += i + 1;
      accumulator -= nums[i];
    }

    return accumulator;
  }
}

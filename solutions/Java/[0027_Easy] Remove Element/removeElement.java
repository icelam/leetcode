class Solution {
  public int removeElement(int[] nums, int val) {
    int length = nums.length;

    for (int i = 0; i < length; i++) {
      while (nums[i] == val && i < length) {
        nums[i] = nums[length - 1];
        nums[length - 1] = val;
        length--;
      }
    }

    return length;
  }
}

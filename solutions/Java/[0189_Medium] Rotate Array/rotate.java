class Solution {
  public void reverseSubArray(int[] nums, int start, int end) {
    while (start <= end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }

  public void rotate(int[] nums, int k) {
    int numberOfShift = k % nums.length;
    reverseSubArray(nums, 0, nums.length - 1);
    reverseSubArray(nums, 0, numberOfShift - 1);
    reverseSubArray(nums, numberOfShift, nums.length - 1);
  }
}

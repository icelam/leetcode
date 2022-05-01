class Solution {
  public int[] sortedSquares(int[] nums) {
    int i = 0;
    int j = nums.length - 1;
    int[] result = new int[nums.length];

    for (int k = nums.length - 1; k >= 0; k--) {
      if (Math.abs(nums[i]) >= Math.abs(nums[j])) {
        result[k] = (int) Math.pow(nums[i], 2);
        i++;
      } else {
        result[k] = (int) Math.pow(nums[j], 2);
        j--;
      }
    }

    return result;
  }
}

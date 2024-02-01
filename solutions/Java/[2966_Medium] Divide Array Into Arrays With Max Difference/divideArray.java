class Solution {
  public int[][] divideArray(int[] nums, int k) {
    int n = nums.length;
    int m = n / 3;
    int[][] result = new int[m][3];

    Arrays.sort(nums);

    for (int i = 0; i < n; i++) {
      int row = i / 3;
      int column = i % 3;

      if (column == 0 && nums[i + 2] - nums[i] > k) {
        return new int[0][0];
      }

      result[row][column] = nums[i];
    }

    return result;
  }
}

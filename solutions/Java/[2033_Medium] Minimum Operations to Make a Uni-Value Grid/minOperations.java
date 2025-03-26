class Solution {
  public int minOperations(int[][] grid, int x) {
    int height = grid.length;
    int width = grid[0].length;
    int n = width * height;
    Integer[] nums = new Integer[n];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        nums[i * width + j] = grid[i][j];
      }
    }

    Arrays.sort(nums);
    int median = nums[n / 2];
    int result = 0;

    for (int value: nums) {
      int diff = Math.abs(median - value);

      if (diff == 0) {
        continue;
      }

      if (diff % x != 0) {
        return -1;
      }

      result += diff / x;
    }

    return result;
  }
}

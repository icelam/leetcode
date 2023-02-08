class Solution {
  public int jump(int[] nums) {
    int result = 0;
    int currentEnd = 0;
    int currentMax = 0;

    for (int i = 0; i < nums.length - 1; i++) {
      currentMax = Math.max(currentMax, i + nums[i]);

      if (i == currentEnd) {
        result++;
        currentEnd = currentMax;
      }
    }

    return result;
  }
}

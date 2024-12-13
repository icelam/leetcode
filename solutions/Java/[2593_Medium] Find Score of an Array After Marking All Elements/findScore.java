class Solution {
  public long findScore(int[] nums) {
    int n = nums.length;
    long score = 0;
    boolean[] marked = new boolean[n];
    int[][] sortedNums = new int[n][2];

    for (int i = 0; i < n; i++) {
      sortedNums[i][0] = nums[i];
      sortedNums[i][1] = i;
    }

    Arrays.sort(sortedNums, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

    for (int i = 0; i < n; i++) {
      int[] current = sortedNums[i];

      if (marked[current[1]]) {
        continue;
      }

      score += current[0];

      if (current[1] - 1 >= 0) {
        marked[current[1] - 1] = true;
      }

      if (current[1] + 1 < n) {
        marked[current[1] + 1] = true;
      }
    }

    return score;
  }
}

class Solution {
  public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
    Arrays.sort(factory, (a, b) -> a[0] - b[0]);
    int[] robots = robot.stream().mapToInt(i -> i).toArray();
    Arrays.sort(robots);
    int m = robots.length;
    long[] dp = new long[m + 1];
    Arrays.fill(dp, (long) 1e18);
    dp[0] = 0;

    for (int[] f: factory) {
      for (int j = m; j > 0; j--) {
        long cost = 0;
        for (int k = 1; k <= Math.min(j, f[1]); k++) {
          cost += Math.abs(robots[j - k] - f[0]);
          dp[j] = Math.min(dp[j], dp[j - k] + cost);
        }
      }
    }

    return dp[m];
  }
}

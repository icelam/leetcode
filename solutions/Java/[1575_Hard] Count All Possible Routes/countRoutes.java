class Solution {
  private static int MOD = (int) (1e9 + 7);

  private int[][] dp;

  private int dfs(int[] locations, int n, int start, int finish, int remainingFuel) {
    if (dp[start][remainingFuel] != -1) {
      return dp[start][remainingFuel];
    }

    int count = start == finish ? 1 : 0;

    for (int currentLocation = 0; currentLocation < n; currentLocation++) {
      if (currentLocation == start) {
        continue;
      }

      int requiredFuel = Math.abs(locations[currentLocation] - locations[start]);

      if (remainingFuel >= requiredFuel) {
        count += dfs(locations, n, currentLocation, finish, remainingFuel - requiredFuel);
        count %= MOD;
      }
    }

    dp[start][remainingFuel] = count;
    return count;
  }

  public int countRoutes(int[] locations, int start, int finish, int fuel) {
    int n = locations.length;
    dp = new int[n][fuel + 1];

    for (int[] row: dp) {
      Arrays.fill(row, -1);
    }

    return dfs(locations, n, start, finish, fuel);
  }
}

class Solution {
  private int[][][] dp;
  private int MAX_COST = 1000001;

  private int findMinimium(
    int[] houses,
    int[][] cost,
    int numberOfHouses,
    int numberOfColors,
    int target,
    int currentHouseIndex,
    int previousColor
  ) {
    // House index exceed limit and target neighbor number match,
    // this means we find a possible combination.
    // No house, no cost. Just return 0 as base case.
    if (currentHouseIndex == numberOfHouses && target == 0) {
      return 0;
    }

    // Too much neighbor now or house index exceed limit but does not match target neighbor number,
    // this is not a valid combination. Mark a number to indicate this case have been visited and
    // is invalid. The number 1000001 instead of Integer.MAX_VALUE is choosen to prevent overflow,
    // where it is +1 of highest possible cost 10^4 (maximum cost) * 100 (maximum house length)
    if (target < 0 || currentHouseIndex == numberOfHouses) {
      return MAX_COST;
    }

    // We met this before, no need to re-calculate
    if (dp[currentHouseIndex][previousColor][target] != -1) {
      return dp[currentHouseIndex][previousColor][target];
    }

    // Painted last year, cannot repaint, no cost for current house
    if (houses[currentHouseIndex] != 0) {
      int currentColor = houses[currentHouseIndex];

      dp[currentHouseIndex][previousColor][target] = findMinimium(
        houses,
        cost,
        numberOfHouses,
        numberOfColors,
        target - (previousColor == currentColor ? 0 : 1),
        currentHouseIndex + 1,
        currentColor
      );

      return dp[currentHouseIndex][previousColor][target];
    }

    int result = MAX_COST;

    // Loop through all possible colors for current unpainted house,
    // and go through the process again for next house
    for (int currentColor = 1; currentColor <= numberOfColors; currentColor++) {
      int nextCost =  findMinimium(
        houses,
        cost,
        numberOfHouses,
        numberOfColors,
        target - (previousColor == currentColor ? 0 : 1),
        currentHouseIndex + 1,
        currentColor
      );

      int currentCost = cost[currentHouseIndex][currentColor - 1];

      result = Math.min(result, nextCost + currentCost);
    }

    dp[currentHouseIndex][previousColor][target] = result;

    return result;
  }

  public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
    // dp[i][j][k] where i = house index, j = color, k = number of neighborhoods
    dp = new int[m][n + 1][target + 1];
    for (int[][] firstLevelRow: dp) {
      for (int[] secondLevelRow: firstLevelRow) {
        Arrays.fill(secondLevelRow, -1);
      }
    }

    int minumiumCost = findMinimium(houses, cost, m, n, target, 0, 0);

    return minumiumCost >= MAX_COST ? -1 : minumiumCost;
  }
}

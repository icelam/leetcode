class Solution {
  private static int MOD = (int) (1e9 + 7);
  private int[] dp;

  private int backtrack(int index, int low, int high, int zero, int one) {
    if (index > high) {
      return 0;
    }

    if (index == high) {
      return 1;
    }

    if (dp[index] != -1) {
      return dp[index];
    }

    int numberOfGoodStrings = 0;

    if (index >= low) {
      numberOfGoodStrings = (numberOfGoodStrings + 1) % MOD;
    }

    numberOfGoodStrings = (backtrack(index + zero, low, high, zero, one) + numberOfGoodStrings) % MOD;
    numberOfGoodStrings = (backtrack(index + one, low, high, zero, one) + numberOfGoodStrings) % MOD;

    dp[index] = numberOfGoodStrings;
    return dp[index];
  }

  public int countGoodStrings(int low, int high, int zero, int one) {
    dp = new int[high];
    Arrays.fill(dp, -1);
    return backtrack(0, low, high, zero, one);
  }
}

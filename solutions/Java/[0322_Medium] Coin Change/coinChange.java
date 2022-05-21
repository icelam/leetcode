class Solution {
  public int coinChange(int[] coins, int amount) {
    int[] memo = new int[amount + 1];
    Arrays.fill(memo, 1, amount + 1, amount + 1);

    for (int i = 1; i <= amount; i++) {
      for (int c: coins) {
        if (i >= c) {
          memo[i] = Math.min(memo[i], 1 + memo[i - c]);
        }
      }
    }

    return memo[amount] < amount + 1 ? memo[amount] : -1;
  }
}

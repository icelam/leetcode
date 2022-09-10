class Solution {
  public int maxProfit(int k, int[] prices) {
    int[] costs = new int[k + 1];
    int[] profits = new int[k + 1];

    Arrays.fill(costs, Integer.MAX_VALUE);

    for (int currentPrice: prices) {
      for (int i = 1; i <= k; i++) {
        costs[i] = Math.min(costs[i], currentPrice - profits[i - 1]);
        profits[i] = Math.max(profits[i], currentPrice - costs[i]);
      }
    }

    return profits[k];
  }
}

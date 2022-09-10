class Solution {
  public int maxProfit(int k, int[] prices) {
    int numberOfDays = prices.length;
    
    if (numberOfDays == 0) {
      return 0;
    }

    int maxNumberOfTransactions = Math.min(k, numberOfDays / 2);
    
    int[][] costs = new int[numberOfDays][maxNumberOfTransactions + 1];
    int[][] profits = new int[numberOfDays][maxNumberOfTransactions + 1];

    costs[0][0] = -prices[0];
    profits[0][0] = 0;
    
    for (int i = 1; i <= maxNumberOfTransactions; ++i) {
      costs[0][i] = (int) -(10e4 + 1);
      profits[0][i] = (int) -(10e4 + 1);
    }

    for (int i = 1; i < numberOfDays; ++i) {
      costs[i][0] = Math.max(costs[i - 1][0], profits[i - 1][0] - prices[i]);
      
      for (int j = 1; j <= maxNumberOfTransactions; ++j) {
        costs[i][j] = Math.max(costs[i - 1][j], profits[i - 1][j] - prices[i]);
        profits[i][j] = Math.max(profits[i - 1][j], costs[i - 1][j - 1] + prices[i]);   
      }
    }

    int result = Integer.MIN_VALUE;
    
    for (int profit: profits[numberOfDays - 1]) {
      result = Math.max(result, profit);
    }
    
    return result;
  }
}
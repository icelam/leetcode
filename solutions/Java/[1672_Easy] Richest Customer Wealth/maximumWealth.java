class Solution {
  public int maximumWealth(int[][] accounts) {
    int maxWealth = 0;

    for (int[] account: accounts) {
      int sum = 0;

      for (int wealth: account) {
        sum += wealth;
      }

      maxWealth = Math.max(maxWealth, sum);
    }

    return maxWealth;
  }
}

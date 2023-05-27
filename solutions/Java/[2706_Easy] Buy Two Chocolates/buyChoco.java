class Solution {
  public int buyChoco(int[] prices, int money) {
    Arrays.sort(prices);

    int cheapestCookiesSum = prices[0] + prices[1];

    if (cheapestCookiesSum > money) {
      return money;
    }

    return money - cheapestCookiesSum;
  }
}

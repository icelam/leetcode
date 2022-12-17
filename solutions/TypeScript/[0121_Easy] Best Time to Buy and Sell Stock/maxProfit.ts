function maxProfit(prices: number[]): number {
  let minPrice = prices[0];
  let possibleMaxProfit = 0;

  for (let i = 0; i < prices.length; i++) {
    if (prices[i] < minPrice) {
      minPrice = prices[i];
    } else if (prices[i] - minPrice > possibleMaxProfit) {
      possibleMaxProfit = prices[i] - minPrice;
    }
  }

  return possibleMaxProfit;
}

function maxProfit(prices: number[]): number {
  let low: null | number = null;
  let high: null | number = null;
  let possibleMaxProfit = 0;

  function setPossibleProfit () {
    if (high !== null && low !== null) {
      if (high - low > possibleMaxProfit) {
        possibleMaxProfit = high - low;
      }
    }

    low = null;
    high = null;
  }

  for (let i = 0; i < prices.length; i++) {
    if (low === null || prices[i] <= low) {
      setPossibleProfit();
      low = prices[i];
      continue;
    }

    if (high === null || prices[i] > high) {
      high = prices[i];
    }
  }

  setPossibleProfit();
  return possibleMaxProfit;
}

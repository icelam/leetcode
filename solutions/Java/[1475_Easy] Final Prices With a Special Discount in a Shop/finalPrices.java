class Solution {
  public int[] finalPrices(int[] prices) {
    int n = prices.length;
    int[] discountedPrices = new int[n];

    for (int i = 0; i < n; i++) {
      int discountAmount = 0;

      for (int j = i + 1; j < n; j++) {
        if (prices[j] <= prices[i]) {
          discountAmount = prices[j];
          break;
        }
      }

      discountedPrices[i] = prices[i] - discountAmount;
    }

    return discountedPrices;
  }
}

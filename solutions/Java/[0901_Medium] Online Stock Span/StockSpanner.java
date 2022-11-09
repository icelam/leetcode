class StockSpanner {
  private Stack<int[]> allPrices;

  public StockSpanner() {
    allPrices = new Stack<>();
  }

  public int next(int price) {
    int span = 1;
    while (!allPrices.isEmpty() && allPrices.peek()[0] <= price) {
      span += allPrices.pop()[1];
    }

    allPrices.push(new int[]{price, span});
    return span;
  }
}

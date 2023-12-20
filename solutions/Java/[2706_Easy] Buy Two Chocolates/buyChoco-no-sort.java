class Solution {
  public int buyChoco(int[] prices, int money) {
    int cheapestChoco = Integer.MAX_VALUE;
    int secondCheapestChoco = Integer.MAX_VALUE;

    for (int p: prices) {
      if (p < cheapestChoco) {
        secondCheapestChoco = cheapestChoco;
        cheapestChoco = p;
      } else if (p < secondCheapestChoco) {
        secondCheapestChoco = p;
      }
    }

    int remainingMoney = money - cheapestChoco - secondCheapestChoco;

    if (remainingMoney >= 0) {
      return remainingMoney;
    }

    return money;
  }
}

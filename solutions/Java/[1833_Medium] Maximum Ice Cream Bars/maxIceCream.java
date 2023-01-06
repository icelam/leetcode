class Solution {
  public int maxIceCream(int[] costs, int coins) {
    Arrays.sort(costs);

    int n = costs.length;
    int numberOfBarsBought = 0;

    for (int i = 0; i < n && coins >= costs[i]; i++) {
      coins -= costs[i];
      numberOfBarsBought++;
    }

    return numberOfBarsBought;
  }
}

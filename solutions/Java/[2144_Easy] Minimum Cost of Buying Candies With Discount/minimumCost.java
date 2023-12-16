class Solution {
  public int minimumCost(int[] cost) {
    Arrays.sort(cost);

    int n = cost.length;
    int totalCost = 0;
    int k = n % 3;

    for (int i = 0; i < n; i++) {
      if (i % 3 == k && i >= k) {
        continue;
      }

      totalCost += cost[i];
    }

    return totalCost;
  }
}

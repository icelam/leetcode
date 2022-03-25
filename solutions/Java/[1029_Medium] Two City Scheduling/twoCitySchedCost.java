class Solution {
  public int twoCitySchedCost(int[][] costs) {
    int result = 0;

    // Sort by difference in cost
    Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));

    // Sending first half to A and second half to B
    int middle = costs.length / 2;
    for (int i = 0; i < middle; i++) {
      result += costs[i][0] + costs[i + middle][1];
    }

    return result;
  }
}

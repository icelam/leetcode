class Solution {
  public double averageWaitingTime(int[][] customers) {
    int n = customers.length;
    int currentTime = 1;
    long totalWaitingTime = 0;

    for (int[] order: customers) {
      int currentWaitingTime = 0;

      if (currentTime < order[0]) {
        currentTime = order[0];
      } else if (currentTime > order[0]) {
        currentWaitingTime += currentTime - order[0];
      }

      currentTime += order[1];
      totalWaitingTime += currentWaitingTime + order[1];
    }

    return (double) totalWaitingTime / n;
  }
}

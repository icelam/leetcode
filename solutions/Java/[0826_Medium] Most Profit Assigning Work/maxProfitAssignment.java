class Solution {
  public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    int n = difficulty.length;
    int m = worker.length;
    int result = 0;

    int[][] jobs = new int[n][2];

    for (int i = 0; i < n; i++) {
      jobs[i][0] = difficulty[i];
      jobs[i][1] = profit[i];
    }

    Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
    Arrays.sort(worker);

    int currentMaxProfit = 0;
    int i = 0;

    for (int ability: worker) {
      while (i < n && jobs[i][0] <= ability) {
        currentMaxProfit = Math.max(currentMaxProfit, jobs[i][1]);
        i++;
      }

      result += currentMaxProfit;
    }

    return result;
  }
}

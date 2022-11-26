class Solution {
  public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
    int n = startTime.length;
    int[][] jobs = new int[n][];

    for (int i = 0; i < n; i++) {
      jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
    }

    Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    int maxProfit = 0;

    for (int i = 0; i < n; i++) {
      while (!pq.isEmpty() && jobs[i][0] >= pq.peek()[1]) {
        int[] possibleJob = pq.remove();
        maxProfit = Math.max(maxProfit, possibleJob[2]);
      }

      pq.add(new int[] {jobs[i][0], jobs[i][1], jobs[i][2] + maxProfit});
    }

    while (!pq.isEmpty()) {
      int[] possibleJob = pq.remove();
      maxProfit = Math.max(maxProfit, possibleJob[2]);
    }

    return maxProfit;
  }
}

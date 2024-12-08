class Solution {
  public int maxTwoEvents(int[][] events) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

    Arrays.sort(events, (a, b) -> a[0] - b[0]);

    int maxValue = 0;
    int maxSum = 0;

    for (int[] event : events) {
      while (!pq.isEmpty() && pq.peek()[0] < event[0]) {
        maxValue = Math.max(maxValue, pq.peek()[1]);
        pq.remove();
      }

      maxSum = Math.max(maxSum, maxValue + event[2]);
      pq.add(new int[]{event[1], event[2]});
    }

    return maxSum;
  }
}

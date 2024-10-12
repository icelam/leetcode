class Solution {
  public int minGroups(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int[] interval: intervals) {
      if (!pq.isEmpty() && interval[0] > pq.peek()) {
        pq.remove();
      }

      pq.add(interval[1]);
    }

    return pq.size();
  }
}

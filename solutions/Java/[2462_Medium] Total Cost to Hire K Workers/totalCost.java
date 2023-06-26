class Solution {
  public long totalCost(int[] costs, int k, int candidates) {
    int n = costs.length;
    PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
    int start = 0;
    int end = n - 1;
    int remainingHires = k;
    long totalCost = 0;

    int count = 0;
    while (count < candidates && start <= end) {
      heap.add(new int[]{costs[start], start, 0});
      count++;
      start++;
    }

    count = 0;
    while (count < candidates && end > start) {
      heap.add(new int[]{costs[end], end, 1});
      count++;
      end--;
    }

    while (remainingHires > 0) {
      int[] workerHired = heap.remove();
      totalCost += workerHired[0];

      if (start <= end) {
        if (workerHired[2] == 0) {
          heap.add(new int[]{costs[start], start, 0});
          start++;
        } else {
          heap.add(new int[]{costs[end], end, 1});
          end--;
        }
      }

      remainingHires--;
    }

    return totalCost;
  }
}

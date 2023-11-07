class Solution {
  public int eliminateMaximum(int[] dist, int[] speed) {
    int n = dist.length;
    PriorityQueue<Double> arrivals = new PriorityQueue<>();

    for (int i = 0; i < n; i++) {
      arrivals.add((double) dist[i] / speed[i]);
    }

    int currentTime = 0;

    while (!arrivals.isEmpty() && arrivals.peek() > currentTime) {
      currentTime++;
      arrivals.remove();
    }

    return currentTime;
  }
}

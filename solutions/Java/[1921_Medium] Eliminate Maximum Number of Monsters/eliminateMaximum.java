class Solution {
  public int eliminateMaximum(int[] dist, int[] speed) {
    int n = dist.length;
    double[] arrivals = new double[n];

    for (int i = 0; i < n; i++) {
      arrivals[i] = (double) dist[i] / speed[i];
    }

    Arrays.sort(arrivals);

    int currentTime = 0;

    while (currentTime < n && arrivals[currentTime] > currentTime) {
      currentTime++;
    }

    return currentTime;
  }
}

class Solution {
  public int findPoisonedDuration(int[] timeSeries, int duration) {
    int n = timeSeries.length;
    int totalDuration = 0;

    for (int i = 1; i < n; i++) {
      totalDuration += Math.min(duration, timeSeries[i] - timeSeries[i - 1]);
    }

    return totalDuration + duration;
  }
}

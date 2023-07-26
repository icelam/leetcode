class Solution {
  private boolean canReach(int[] dist, double hour, int speed) {
    double timeNeeded = 0.0;

    for (int i = 0; i < dist.length - 1; i++) {
      // `(x + y - 1) / y` is a faster replacement for `Math.ceil((double) dist[i] / speed)`.
      // This is to prevent default round down mechanism of Java when dividing two int values.
      timeNeeded += (dist[i] + speed - 1) / speed;
    }

    timeNeeded += (double) dist[dist.length - 1] / speed;
    return timeNeeded <= hour;
  }

  public int minSpeedOnTime(int[] dist, double hour) {
    if (dist.length > Math.ceil(hour)) {
      return -1;
    }

    int left = 1;
    int right = 10_000_000;

    while (left < right) {
      int middle = left + (right - left) / 2;
      if (canReach(dist, hour, middle)) {
        right = middle;
      } else {
        left = middle + 1;
      }
    }

    return left;
  }
}

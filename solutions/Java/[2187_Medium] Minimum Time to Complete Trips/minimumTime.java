class Solution {
  public long minimumTime(int[] time, int totalTrips) {
    int maxTime = 0;

    for (int t: time) {
      maxTime = Math.max(maxTime, t);
    }

    long left = (long) 1;
    long right = (long) totalTrips * maxTime;

    while (left < right) {
      long middle = left + (right - left) / 2;
      long count = 0;

      for (int t: time) {
        count += middle / t;
      }

      if (count >= totalTrips) {
        right = middle;
      } else {
        left = middle + 1;
      }
    }

    return left;
  }
}

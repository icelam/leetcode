class Solution {
  public long repairCars(int[] ranks, int cars) {
    int min = ranks[0];

    for (int currentRanl : ranks) {
      min = Math.min(min, currentRanl);
    }

    long left = 0;
    long right = (long) min * cars * cars;

    while (left + 1 < right) {
      long middle = left + (right - left) / 2;
      long sum = 0;

      for (int currentRank : ranks) {
        sum += Math.sqrt(middle / currentRank);
      }

      if (sum >= cars) {
        right = middle;
      } else {
        left = middle;
      }
    }

    return right;
  }
}

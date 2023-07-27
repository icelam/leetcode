class Solution {
  // K = Number of computers, P = time for all computers to run in parallel,
  // This is to check if state of battery can be fit into P * K metrics.
  // Here is a good blog that explains the concept with illustrations:
  // https://qiita.com/recuraki/items/02e6127170eaa9ed5111
  private boolean canRun(long time, int[] batteries, int n) {
    long totalPower = 0;

    for (int power : batteries) {
      totalPower += Math.min(power, time);
    }

    return totalPower >= n * time;
  }

  public long maxRunTime(int n, int[] batteries) {
    long totalPower = 0;
    for (int power: batteries) {
      totalPower += power;
    }

    long left = 1;
    long right = totalPower / n;
    long result = 0;

    while (left <= right) {
      long middle = left + (right - left) / 2;

      if (canRun(middle, batteries, n)) {
        left = middle + 1;
      } else {
        right = middle - 1;
      }
    }

    return left - 1;
  }
}


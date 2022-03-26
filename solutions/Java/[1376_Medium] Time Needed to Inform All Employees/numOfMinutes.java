class Solution {
  private int calculateTime(int managerId, int[] manager, int[] informTime, int[] cache) {
    if (managerId == -1) {
      return 0;
    }

    if (cache[managerId] != -1) {
      return cache[managerId];
    }

    cache[managerId] = informTime[managerId] + calculateTime(manager[managerId], manager, informTime, cache);

    return cache[managerId];
  }

  public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    if (n == 1) {
      return informTime[0];
    }

    int maxTime = 0;
    int[] cache = new int[n];
    Arrays.fill(cache, -1);

    for (int m: manager) {
      maxTime = Math.max(maxTime, calculateTime(m, manager, informTime, cache));
    }

    return maxTime;
  }
}

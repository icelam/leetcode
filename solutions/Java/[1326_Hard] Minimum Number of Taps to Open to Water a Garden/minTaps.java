class Solution {
  public int minTaps(int n, int[] ranges) {
    int numberOfTaps = n + 1;
    int[][] coverArea = new int[numberOfTaps][2];

    for (int i = 0; i <= n; ++i) {
      coverArea[i][0] = Math.max(0, i - ranges[i]);
      coverArea[i][1] = Math.min(n, i + ranges[i]);
    }

    Arrays.sort(coverArea, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

    int minTapToOpen = 1;
    int end = coverArea[0][1];
    int next = 1;

    while (end < n) {
      int maxReach = 0;

      for (int i = next; i <= n && coverArea[i][0] <= end; i++) {
        if (coverArea[i][0] != coverArea[i - 1][0] && coverArea[i][1] >= maxReach) {
          next = i;
          maxReach = coverArea[i][1];
        }
      }

      if (end >= maxReach) {
        return -1;
      }

      minTapToOpen++;
      end = maxReach;
    }

    return minTapToOpen;
  }
}


class Solution {
  public boolean isCovered(int[][] ranges, int left, int right) {
    Arrays.sort(ranges, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

    int min = ranges[0][0];
    int max = ranges[0][1];

    for (int i = 1; i < ranges.length; i++) {
      if (ranges[i][0] <= max + 1) {
        min = Math.min(min, ranges[i][0]);
        max = Math.max(max, ranges[i][1]);
      } else {
        if (min <= left && max >= right) {
          return true;
        }

        min = ranges[i][0];
        max = ranges[i][1];
      }
    }

    return min <= left && max >= right;
  }
}

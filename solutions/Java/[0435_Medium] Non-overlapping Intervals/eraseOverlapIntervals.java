class Solution {
  public int eraseOverlapIntervals(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

    int end = Integer.MIN_VALUE;
    int result = 0;

    for (int i = 0; i < intervals.length; i++) {
      if (intervals[i][0] >= end) {
        end = intervals[i][1];
      } else {
        result++;
      }
    }


    return result;
  }
}

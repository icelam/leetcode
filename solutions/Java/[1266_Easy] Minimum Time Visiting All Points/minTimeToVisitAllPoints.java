class Solution {
  public int minTimeToVisitAllPoints(int[][] points) {
    int n = points.length;
    int result = 0;

    for (int i = 1; i < n; i++) {
      result += Math.max(Math.abs(points[i][0] - points[i - 1][0]), Math.abs(points[i][1] - points[i - 1][1]));
    }

    return result;
  }
}

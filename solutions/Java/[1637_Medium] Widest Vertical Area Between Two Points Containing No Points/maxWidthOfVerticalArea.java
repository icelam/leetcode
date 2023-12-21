class Solution {
  public int maxWidthOfVerticalArea(int[][] points) {
    int n = points.length;
    int maxDistance = 0;
    Arrays.sort(points, (a, b) -> a[0] - b[0]);

    for (int i = 1; i <= n - 1; i++) {
      int currentDistance = points[i][0] - points[i - 1][0];
      maxDistance = Math.max(maxDistance, currentDistance);
    }

    return maxDistance;
  }
}

class Solution {
  public int findMinArrowShots(int[][] points) {
    int numberOfBalloons = points.length;
    // Same as a[1] - b[1], but use if else to prevent integer overflow
    // on test cases like [[-2147483646,-2147483645],[2147483646,2147483647]].
    // Starting point doesn't seems to matter.
    Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

    int lastShootPosition = points[0][1];
    int result = 1;

    for (int i = 1; i < numberOfBalloons; i++) {
      if (points[i][0] > lastShootPosition) {
        lastShootPosition = points[i][1];
        result++;
      }
    }

    return result;
  }
}

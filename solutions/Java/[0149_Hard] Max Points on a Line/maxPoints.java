class Solution {
  public double getSlope(int[] point1, int[] point2) {
    double x1 = point1[0];
    double x2 = point2[0];
    double y1 = point1[1];
    double y2 = point2[1];

    return (y2 - y1) / (x2 - x1);
  }

  public int maxPoints(int[][] points) {
    int n = points.length;

    if (n == 1) {
      return 1;
    }

    int result = 0;

    for (int i = 0; i < n; i++) {
      Map<Double, Integer> currentCount = new HashMap<>();

      for (int j = 0; j < n; j++) {
        if (i != j) {
          double slope = getSlope(points[i], points[j]);
          currentCount.put(slope, currentCount.getOrDefault(slope, 0) + 1);
        }
      }

      System.out.println(currentCount);

      result = Math.max(result, Collections.max(currentCount.values()) + 1);
    }

    return result;
  }
}

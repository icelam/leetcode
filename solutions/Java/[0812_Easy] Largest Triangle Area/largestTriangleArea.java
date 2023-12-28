class Solution {
  double calculateArea(int[] a, int[] b, int[] c) {
    return 0.5 * Math.abs(a[0] * b[1] + b[0] * c[1] + c[0] * a[1] - a[0] * c[1] - b[0] * a[1] - c[0] * b[1]);
  }

  public double largestTriangleArea(int[][] points) {
    int n = points.length;
    double largestArea = 0.0;

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        for (int k = j + 1; k < n; k++) {
          largestArea = Math.max(largestArea, calculateArea(points[i], points[j], points[k]));
        }
      }
    }

    return largestArea;
  }
}

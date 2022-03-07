class Solution {
  // Mathmetical ways of determining a straight line:
  // https://www.mathcentre.ac.uk/resources/uploaded/mc-ty-strtlines-2009-1.pdf
  double calculateGradient(int[] c1, int[] c2) {
    if (c1[0] == c2[0]) {
      return Double.POSITIVE_INFINITY;
    }

    return (c2[1] - c1[1]) * 1.0 / (c2[0] - c1[0]);
  }

  public boolean checkStraightLine(int[][] coordinates) {
    double expectedGradient = calculateGradient(coordinates[0], coordinates[1]);

    for (int i = 2; i < coordinates.length; i++) {
      if (calculateGradient(coordinates[i - 1], coordinates[i]) != expectedGradient) {
        return false;
      }
    }

    return true;
  }
}

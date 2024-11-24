class Solution {
  private int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

  public long maxMatrixSum(int[][] matrix) {
    int height = matrix.length;
    int width = matrix[0].length;
    int negativeCount = 0;
    int minValue = Integer.MAX_VALUE;
    long sum = 0;

    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        if (matrix[row][column] < 0) {
          negativeCount++;
        }

        int absoluteValue = Math.abs(matrix[row][column]);
        sum += absoluteValue;
        minValue = Math.min(minValue, absoluteValue);
      }
    }

    if (negativeCount % 2 != 0) {
      sum -= 2 * minValue;
    }

    return sum;
  }
}

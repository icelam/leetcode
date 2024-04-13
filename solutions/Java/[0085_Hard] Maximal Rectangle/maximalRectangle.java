class Solution {
  public int maximalRectangle(char[][] matrix) {
    int height = matrix.length;
    int width = matrix[0].length;
    int[][] frequencyOnRow = new int[height][width];
    int maxArea = 0;

    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        if (matrix[row][column] == '1') {
          if (column == 0) {
            frequencyOnRow[row][column] = 1;
          } else {
            frequencyOnRow[row][column] = frequencyOnRow[row][column - 1] + 1;
          }
        }
      }
    }

    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        if (matrix[row][column] == '0') {
          continue;
        }

        int currentWidth = frequencyOnRow[row][column];
        int area = currentWidth;

        for (int i = row - 1; i >= 0; i--) {
          currentWidth = Math.min(currentWidth, frequencyOnRow[i][column]);
          area = Math.max(area, (row - i + 1) * currentWidth);
        }

        maxArea = Math.max(maxArea, area);
      }
    }

    return maxArea;
  }
}

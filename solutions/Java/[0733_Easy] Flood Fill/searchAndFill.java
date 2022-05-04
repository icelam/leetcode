class Solution {
  public boolean isValidPosition(int row, int column, int height, int width) {
    return row >= 0 && row <= height - 1 && column >= 0 && column <= width - 1;
  }

  public void searchAndFill(int[][] image, int row, int column, int oldColor, int newColor) {
    if (
      !isValidPosition(row, column, image.length, image[0].length)
      || image[row][column] != oldColor
      || image[row][column] == newColor
    ) {
      return;
    }

    image[row][column] = newColor;

    searchAndFill(image, row - 1, column, oldColor, newColor);
    searchAndFill(image, row + 1, column, oldColor, newColor);
    searchAndFill(image, row, column - 1, oldColor, newColor);
    searchAndFill(image, row, column + 1, oldColor, newColor);
  }

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    searchAndFill(image, sr, sc, image[sr][sc], newColor);
    return image;
  }
}

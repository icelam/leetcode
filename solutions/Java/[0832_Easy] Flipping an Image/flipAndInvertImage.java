class Solution {
  public int[][] flipAndInvertImage(int[][] image) {
    int height = image.length;
    int width = image[0].length;
    int[][] result = new int[height][width];

    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        result[row][width - column - 1] = image[row][column] == 1 ? 0 : 1;
      }
    }

    return result;
  }
}

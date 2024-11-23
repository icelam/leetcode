class Solution {
  public char[][] rotateTheBox(char[][] box) {
    int height = box.length;
    int width = box[0].length;

    for (int row = 0; row < height; row++) {
      int front = width - 1;

      for (int column = width - 1; column >= 0; column--) {
        if (box[row][column] == '*') {
          front = column - 1;
        } else if (box[row][column] == '#') {
          if (front > column) {
            box[row][front] = '#';
            box[row][column] = '.';
            front--;
          } else {
            front = column - 1;
          }
        }
      }
    }

    char[][] result = new char[width][height];

    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        result[column][height - row - 1] = box[row][column];
      }
    }

    return result;
  }
}

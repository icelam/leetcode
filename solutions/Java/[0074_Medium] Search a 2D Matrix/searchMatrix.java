class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int columnCount = matrix[0].length;
    int length = columnCount * matrix.length;

    int left = 0;
    int right = length - 1;
    int middle = length / 2;

    while (left <= right) {
      middle = (left + right) / 2;
      int y = middle / columnCount;
      int x = middle % columnCount;
      int key = matrix[y][x];

      if (target == key) {
        return true;
      }

      if (target < key) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }

    return false;
  }
}

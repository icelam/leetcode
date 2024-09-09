class Solution {
  public int[][] generateMatrix(int n) {
    int[][] result = new int[n][n];

    // Boundary of top, right, bottom, left
    int[] boundaries = {0, n - 1, n - 1,  0};
    // 0 = right, 1 = down, 2 = left, 3 = up
    int direction = 0;
    int num = 0;

    while (boundaries[0] <= boundaries[2] && boundaries[3] <= boundaries[1]) {
      if (direction % 4 == 0) {
        // right = row + 0, col + 1 || check row end (right) || reach end do row start (top) + 1
        for (int i = boundaries[3]; i <= boundaries[1]; i++) {
          result[boundaries[0]][i] = ++num;
        }

        boundaries[0]++;
      } else if (direction % 4 == 1) {
        // down = row + 1, col + 0 || check col end (bottom) || reach end do col end (right) - 1
        for (int i = boundaries[0]; i <= boundaries[2]; i++) {
          result[i][boundaries[1]] = ++num;
        }

        boundaries[1]--;
      } else if (direction % 4 == 2) {
        // left = row + 0, col - 1 || check row start (left) || reach end do row end (bottom) - 1
        for (int i = boundaries[1]; i >= boundaries[3]; i--) {
          result[boundaries[2]][i] = ++num;
        }

        boundaries[2]--;
      } else if (direction % 4 == 3) {
        // up = row - 1, col + 0 || check col start (top) || reach end do col start (left) + 1
        for (int i = boundaries[2]; i >= boundaries[0]; i--) {
          result[i][boundaries[3]] = ++num;
        }

        boundaries[3]++;
      }

      direction++;
    }

    return result;
  }
}

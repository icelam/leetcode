class Solution {
  public boolean checkValid(int[][] matrix) {
    int n = matrix.length;

    for (int row = 0; row < n; row++) {
      boolean[] frequency = new boolean[n + 1];

      for (int column = 0; column < n; column++) {
        int num = matrix[row][column];

        if (frequency[num]) {
          return false;
        }

        frequency[num] = true;
      }
    }

    for (int column = 0; column < n; column++) {
      boolean[] frequency = new boolean[n + 1];

      for (int row = 0; row < n; row++) {
        int num = matrix[row][column];

        if (frequency[num]) {
          return false;
        }

        frequency[num] = true;
      }
    }

    return true;
  }
}

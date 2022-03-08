class Solution {
  public int diagonalSum(int[][] mat) {
    int size = mat.length;
    int sum = 0;

    for (int i = 0; i < size; i++) {
      sum += mat[i][i];

      if (size - 1 - i != i) {
        sum += mat[i][size - 1 - i];
      }
    }

    return sum;
  }
}

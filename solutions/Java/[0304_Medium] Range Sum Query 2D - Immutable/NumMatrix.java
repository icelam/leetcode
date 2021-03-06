class NumMatrix {
  private int[][] cache;

  public NumMatrix(int[][] matrix) {
    this.cache = new int[matrix.length][matrix[0].length + 1];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        cache[i][j + 1] = cache[i][j] + matrix[i][j];
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    int sum = 0;

    for (int i = row1; i <= row2; i++) {
      sum += cache[i][col2 + 1] - cache[i][col1];
    }

    return sum;
  }
}

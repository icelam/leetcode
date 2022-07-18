class Solution {
  public int numSubmatrixSumTarget(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] sum = new int[m + 1][n + 1];

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
      }
    }

    int result = 0;

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        for (int k = 1; k <= i; k++) {
          for (int l = 1; l <= j; l++) {
            if (sum[i][j] - sum[k - 1][j] - sum[i][l - 1] + sum[k - 1][l - 1] == target) {
              result++;
            }
          }
        }
      }
    }

    return result;
  }
}

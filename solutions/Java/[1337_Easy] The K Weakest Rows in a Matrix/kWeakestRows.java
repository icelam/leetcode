class Solution {
  private int calcuulatePower(int[] row) {
    int left = 0;
    int right = row.length - 1;
    int index = -1;

    while (left <= right) {
      int middle = (left + right) / 2;

      if (row[middle] == 0) {
        right = middle - 1;
      } else {
        index = middle;
        left = middle + 1;
      }
    }

    return index + 1;
  }

  public int[] kWeakestRows(int[][] matrix, int limit) {
    int[] result = new int[limit];
    int[] power = new int[matrix.length];

    for (int i = 0; i < matrix.length; i++) {
      int count = 0;
      power[i] = calcuulatePower(matrix[i]);
    }

    for (int j = 0; j < limit; j++) {
      int minIndex = 0;

      for (int k = 0; k < power.length; k++) {
        if (power[k] < power[minIndex]) {
          minIndex = k;
        }
      }

      result[j] = minIndex;
      power[minIndex] = Integer.MAX_VALUE;
    }

    return result;
  }
}

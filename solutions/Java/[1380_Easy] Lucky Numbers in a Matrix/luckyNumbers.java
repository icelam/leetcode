class Solution {
  public List<Integer> luckyNumbers(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int maxOfRowMinumumValue = Integer.MIN_VALUE;
    int minOfColumnMaximumValue = Integer.MAX_VALUE;
    List<Integer> result = new ArrayList<>();

    // Greedy: There will be at most 1 lucky number in each matrix
    // First, locate the maximum value among minimum values of all rows,
    // since lucky number is also the maximum value of column
    for (int row = 0; row < m; row++) {
      int min = Integer.MAX_VALUE;

      for (int column = 0; column < n; column++) {
        if (matrix[row][column] < min) {
          min = matrix[row][column];
        }
      }

      if (min > maxOfRowMinumumValue) {
        maxOfRowMinumumValue = min;
      }
    }

    // Locate the minimum value among all maximum values of all columns,
    // since lucky number is also the minimum value of row
    for (int column = 0; column < n; column++) {
      int max = Integer.MIN_VALUE;

      for (int row = 0; row < m; row++) {
        if (matrix[row][column] > max) {
          max = matrix[row][column];
        }
      }

      if (max < minOfColumnMaximumValue) {
        minOfColumnMaximumValue = max;
      }
    }

    // If we locate the lucky number, add it to result
    if (maxOfRowMinumumValue == minOfColumnMaximumValue) {
      result.add(maxOfRowMinumumValue);
    }

    return result;
  }
}

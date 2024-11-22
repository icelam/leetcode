class Solution {
  public int maxEqualRowsAfterFlips(int[][] matrix) {
    int height = matrix.length;
    int width = matrix[0].length;
    char[] binary = new char[width];
    HashMap<String, Integer> count = new HashMap<>();

    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        binary[column] = (char) ('0' + matrix[row][column] ^ matrix[row][0]);
      }

      String key = new String(binary);
      count.put(key, count.getOrDefault(key, 0) + 1);
    }

    int maxRow = 0;

    for (String key: count.keySet()) {
      maxRow = Math.max(maxRow, count.get(key));
    }

    return maxRow;
  }
}

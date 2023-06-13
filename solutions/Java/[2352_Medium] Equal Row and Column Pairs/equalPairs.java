class Solution {
  public int equalPairs(int[][] grid) {
    int height = grid.length;
    int width = grid[0].length;

    HashMap<String, Integer> rowCount = new HashMap<>();
    HashMap<String, Integer> columnCount = new HashMap<>();

    for (int i = 0; i < height; i++) {
      StringBuilder rowBuilder = new StringBuilder();
      StringBuilder columnBuilder = new StringBuilder();


      for (int j = 0; j < width; j++) {
        rowBuilder.append(grid[i][j]);
        rowBuilder.append(", ");
        columnBuilder.append(grid[j][i]);
        columnBuilder.append(", ");
      }

      String rowValues = rowBuilder.toString();
      String columnValues = columnBuilder.toString();

      rowCount.put(rowValues, rowCount.getOrDefault(rowValues, 0) + 1);
      columnCount.put(columnValues, columnCount.getOrDefault(columnValues, 0) + 1);
    }

    int result = 0;

    for (String rowValues: rowCount.keySet()) {
      if (columnCount.containsKey(rowValues)) {
        result += rowCount.get(rowValues) * columnCount.get(rowValues);
      }
    }

    return result;
  }
}

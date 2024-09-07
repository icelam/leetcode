class SubrectangleQueries {
  private int[][] rectangle;
  private List<int[]> updates;

  public SubrectangleQueries(int[][] rectangle) {
    this.rectangle = rectangle;
    updates = new ArrayList<>();
  }

  public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
    updates.add(new int[]{row1, col1, row2, col2, newValue});
  }

  public int getValue(int row, int col) {
    for (int i = updates.size() - 1; i >= 0; i--) {
      int[] record = updates.get(i);

      if (record[0] <= row && row <= record[2] && record[1] <= col && col <= record[3]) {
        return record[4];
      }
    }

    return rectangle[row][col];
  }
}

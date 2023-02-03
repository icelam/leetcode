class Solution {
  public String convert(String s, int numRows) {
    if (numRows < 2) {
      return s;
    }

    StringBuilder[] rows = new StringBuilder[numRows];
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < numRows; i++) {
      rows[i] = new StringBuilder();
    }

    int rowIndex = 0;
    int direction = -1;

    for (char c: s.toCharArray()) {
      rows[rowIndex].append(c);

      if (rowIndex == 0 || rowIndex == numRows - 1) {
        direction = direction * -1;
      }

      rowIndex += direction;
    }

    for (StringBuilder row: rows) {
      result.append(row);
    }

    return result.toString();
  }
}

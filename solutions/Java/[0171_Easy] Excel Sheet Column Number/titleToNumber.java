class Solution {
  public int titleToNumber(String columnTitle) {
    int sum = 0;
    for (int i = columnTitle.length() - 1, j = 0; i >= 0; i--, j++) {
      sum += (columnTitle.charAt(i) - 64) * Math.pow(26, j);
    }
    return sum;
  }
}

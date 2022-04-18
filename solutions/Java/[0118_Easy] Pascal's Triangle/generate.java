class Solution {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < numRows; i++) {
      List<Integer> row = new ArrayList<>();

      for (int j = 0; j < i + 1; j++) {
        if (j == 0 || j == i) {
          row.add(1);
        } else {
          List<Integer> previousRow = result.get(i - 1);
          row.add(previousRow.get(j - 1) + previousRow.get(j));
        }
      }
      result.add(row);
    }

    return result;
  }
}

class Solution {
  public List<String> cellsInRange(String s) {
    List<String> result = new ArrayList<>();
    char[] range = s.toCharArray();

    for (char column = range[0]; column <= range[3]; column++) {
      for (char row = range[1]; row <= range[4]; row++) {
        StringBuilder builder = new StringBuilder();
        builder.append(column);
        builder.append(row);
        result.add(builder.toString());
      }
    }

    return result;
  }
}

class Solution {
  public int numberOfBeams(String[] bank) {
    int result = 0;
    int previousCount = 0;

    for (String row: bank) {
      int currentCount = 0;

      for (char c: row.toCharArray()) {
        currentCount += c - '0';
      }

      if (currentCount > 0) {
        result += previousCount * currentCount;
        previousCount = currentCount;
      }
    }

    return result;
  }
}

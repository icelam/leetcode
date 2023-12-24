class Solution {
  public int minOperations(String s) {
    char[] characters = s.toCharArray();
    int operations = 0;
    int i = 0;

    for (char c: characters) {
      if (c - '0' != i % 2) {
        operations++;
      }
      i++;
    }

    return Math.min(operations, characters.length - operations);
  }
}

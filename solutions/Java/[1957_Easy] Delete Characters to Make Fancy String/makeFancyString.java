class Solution {
  public String makeFancyString(String s) {
    int n = s.length();
    StringBuilder builder = new StringBuilder();
    char[] characters = s.toCharArray();
    int start = 0;

    for (int i = 0; i < n; i++) {
      int current = start;

      while (current < n && characters[start] == characters[current]) {
        current++;
      }

      int count = current - start;

      for (int j = Math.min(count, 2); j > 0; j--) {
        builder.append(characters[start]);
      }

      start = current;
    }

    return builder.toString();
  }
}

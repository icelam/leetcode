class Solution {
  public String removeStars(String s) {
    char[] characters = s.toCharArray();
    StringBuilder result = new StringBuilder();

    for (char c: characters) {
      if (result.length() > 0 && c == '*') {
        result.deleteCharAt(result.length() - 1);
        continue;
      }

      result.append(c);
    }

    return result.toString();
  }
}

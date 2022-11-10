class Solution {
  public String removeDuplicates(String s) {
    StringBuilder result = new StringBuilder();
    char[] characters = s.toCharArray();

    for (char c: characters) {
      if (result.length() > 0 && c == result.charAt(result.length() - 1)) {
        result.deleteCharAt(result.length() - 1);
        continue;
      }
      result.append(c);
    }

    return result.toString();
  }
}

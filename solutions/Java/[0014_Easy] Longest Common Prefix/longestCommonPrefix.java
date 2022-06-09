class Solution {
  public String longestCommonPrefix(String[] strs) {
    StringBuilder result = new StringBuilder();
    int minLength = 200;

    for (String s: strs) {
      int currentLength = s.length();

      if (currentLength < minLength) {
        minLength = currentLength;
      }
    }

    for (int i = 0; i < strs[0].length(); i++) {
      char c = strs[0].charAt(i);

      for (String s: strs) {
        if (s.length() == 0 || i >= s.length() || s.charAt(i) != c) {
          return result.toString();
        }
      }

      result.append(c);
    }

    return result.toString();
  }
}

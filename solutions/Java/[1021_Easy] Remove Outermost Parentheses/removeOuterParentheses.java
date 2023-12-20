class Solution {
  public String removeOuterParentheses(String s) {
    int open = 0;
    StringBuilder builder = new StringBuilder();

    for (char c: s.toCharArray()) {
      if (c == ')') {
        open--;
      }

      if (open > 0) {
        builder.append(c);
      }

      if (c == '(') {
        open++;
      }
    }

    return builder.toString();
  }
}

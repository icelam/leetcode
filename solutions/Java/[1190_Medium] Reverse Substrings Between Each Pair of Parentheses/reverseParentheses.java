class Solution {
  public String reverseParentheses(String s) {
    Stack<String> stack = new Stack<>();
    StringBuilder builder = new StringBuilder();

    for (char c: s.toCharArray()) {
      if (c == '(') {
        stack.push(builder.toString());
        builder.setLength(0);
      } else if (c == ')') {
        builder.reverse();
        builder.insert(0, stack.pop());
      } else {
        builder.append(c);
      }
    }

    return builder.toString();
  }
}

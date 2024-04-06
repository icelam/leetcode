class Solution {
  public boolean isValid(String s) {
    int n = s.length();
    char[] characters = s.toCharArray();
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < n; i++) {
      char c = characters[i];

      if (c == '(' || c == '[' || c == '{') {
        stack.push(c);
        continue;
      }

      if (!stack.isEmpty()) {
        char p = stack.peek();

        if ((p == '(' && c == ')') || (p == '[' && c == ']') || (p == '{' && c == '}')) {
          stack.pop();
          continue;
        }
      }

      return false;
    }

    return stack.isEmpty();
  }
}

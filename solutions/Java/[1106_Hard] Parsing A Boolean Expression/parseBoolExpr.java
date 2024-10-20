class Solution {
  public boolean parseBoolExpr(String expression) {
    Stack<Character> stack = new Stack<>();

    for (char c: expression.toCharArray()) {
      if (c == ',') {
        continue;
      }

      if (c == ')') {
        boolean[] hasAppearance = new boolean[2];

        while (stack.peek() != '(') {
          hasAppearance[stack.pop() == 'f' ? 0 : 1] |= true;
        }

        stack.pop();

        char operator = stack.pop();

        if (operator == '!') {
          stack.push(hasAppearance[1] ? 'f' : 't');
        } else if (operator == '&') {
          stack.push(hasAppearance[0] ? 'f' : 't');
        } else if (operator == '|') {
          stack.push(hasAppearance[1] ? 't' : 'f');
        }

        continue;
      }

      stack.push(c);
    }

    return stack.peek() == 't';
  }
}

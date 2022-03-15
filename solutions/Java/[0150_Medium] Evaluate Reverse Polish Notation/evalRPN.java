class Solution {
  int calculate(int right, int left, String operation) {
    int result = 0;

    switch (operation) {
      case "+":
        result = left + right;
        break;
      case "-":
        result = left - right;
        break;
      case "*":
        result = left * right;
        break;
      case "/":
        result = left / right;
        break;
    }

    return result;
  }

  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();

    for (String t: tokens) {
      if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
        stack.push(calculate(stack.pop(), stack.pop(), t));
      } else {
        stack.push(Integer.parseInt(t));
      }
    }

    return stack.pop();
  }
}

class Solution {
  public String removeKdigits(String num, int k) {
    if (num.length() == k) {
      return "0";
    }

    Stack<Character> stack = new Stack<Character>();

    for (int i = 0; i < num.length(); i++) {
      while (!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(i)) {
        stack.pop();
        k--;
      }

      if (!(stack.isEmpty() && num.charAt(i) == '0')) {
        stack.push(num.charAt(i));
      }
    }

    while (!stack.isEmpty() && k > 0) {
      stack.pop();
      k--;
    }

    if (stack.isEmpty()) {
      return "0";
    }

    String result = "";
    while (!stack.isEmpty()) {
      char character = stack.pop();
      result = character + result;
    }

    return result;
  }
}

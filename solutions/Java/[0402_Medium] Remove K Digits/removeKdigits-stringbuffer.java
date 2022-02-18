class Solution {
  public class StringStack {
    private StringBuffer stack;

    StringStack() {
      this.stack = new StringBuffer("");
    }

    public char peek() {
      return stack.charAt(stack.length() - 1);
    }

    public void push(char character) {
      this.stack.append(character);
    }

    public void pop() {
      if (this.stack.length() > 0) {
        stack.deleteCharAt(stack.length() - 1);
      }
    }

    public boolean isEmpty() {
      return this.stack.length() == 0;
    }

    public String toString() {
      return this.stack.toString();
    }
  }

  public String removeKdigits(String num, int k) {
    if (num.length() == k) {
      return "0";
    }

    StringStack stack = new StringStack();

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

    return stack.toString();
  }
}

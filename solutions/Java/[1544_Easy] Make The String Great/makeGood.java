class Solution {
  public String makeGood(String s) {
    Stack<Character> stack = new Stack<>();
    char[] characters = s.toCharArray();

    for (char c: characters) {
      if (!stack.isEmpty() && Math.abs(stack.peek() - c) == 32) {
        stack.pop();
        continue;
      }

      stack.add(c);
    }

    StringBuilder result = new StringBuilder();

    while (!stack.isEmpty()) {
      result.append(stack.pop());
    }

    return result.reverse().toString();
  }
}

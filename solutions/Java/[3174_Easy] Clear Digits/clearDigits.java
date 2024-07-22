class Solution {
  public String clearDigits(String s) {
    int n = s.length();
    char[] characters = s.toCharArray();
    Stack<Character> stack = new Stack<>();

    for (char c: characters) {
      if (Character.isDigit(c) && !stack.isEmpty()) {
        stack.pop();
        continue;
      }

      stack.push(c);
    }

    StringBuilder builder = new StringBuilder();

    while (!stack.isEmpty()) {
      builder.append(stack.pop());
    }

    return builder.reverse().toString();
  }
}

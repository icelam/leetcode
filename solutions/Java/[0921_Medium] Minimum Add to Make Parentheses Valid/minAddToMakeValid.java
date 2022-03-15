class Solution {
  public int minAddToMakeValid(String s) {
    int count = 0;
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ')') {
        if (stack.empty() || stack.peek() != '(') {
          count++;
        } else {
          stack.pop();
        }
      } else {
        stack.push('(');
      }
    }

    count += stack.size();

    return count;
  }
}

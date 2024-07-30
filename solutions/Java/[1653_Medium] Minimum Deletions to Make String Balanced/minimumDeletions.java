class Solution {
  public int minimumDeletions(String s) {
    int n = s.length();
    Stack<Character> stack = new Stack<>();
    int result = 0;

    for (char c: s.toCharArray()) {
      if (!stack.isEmpty() && stack.peek() == 'b' && c == 'a') {
        stack.pop();
        result++;
      } else {
        stack.push(c);
      }
    }

    return result;
  }
}

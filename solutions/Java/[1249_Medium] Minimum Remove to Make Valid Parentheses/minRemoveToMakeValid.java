class Solution {
  public String minRemoveToMakeValid(String s) {
    Stack<Integer> stack = new Stack<>();
    StringBuilder result = new StringBuilder(s);

    int i = 0;

    while (i < result.length()) {
      if (result.charAt(i) == '(') {
        stack.push(i);
      } else if (result.charAt(i) == ')') {
        if (stack.empty()) {
          result.delete(i, i + 1);
          i--;
        } else {
          stack.pop();
        }
      }

      i++;
    }

    while (stack.size() > 0) {
      int temp = stack.pop();
      result.delete(temp, temp + 1);
    }

    return result.toString();
  }
}

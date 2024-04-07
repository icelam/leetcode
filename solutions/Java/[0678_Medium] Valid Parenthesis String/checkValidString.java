class Solution {
  public boolean checkValidString(String s) {
    int n = s.length();
    char[] characters = s.toCharArray();
    Stack<Integer> brackets = new Stack<>();
    Stack<Integer> asterisks = new Stack<>();

    for (int i = 0; i < n; i++) {
      char c = characters[i];

      if (c == '(') {
        brackets.push(i);
        continue;
      }

      if (c == '*') {
        asterisks.push(i);
        continue;
      }

      if (!brackets.isEmpty()) {
        brackets.pop();
        continue;
      }

      if (!asterisks.isEmpty()) {
        asterisks.pop();
        continue;
      }

      return false;
    }

    while (!brackets.isEmpty() && !asterisks.isEmpty()) {
      if (brackets.peek() > asterisks.peek()) {
        return false;
      }

      brackets.pop();
      asterisks.pop();
    }

    return brackets.isEmpty();
  }
}

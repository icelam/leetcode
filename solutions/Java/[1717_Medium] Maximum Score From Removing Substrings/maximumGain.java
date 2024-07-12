class Solution {
  public int maximumGain(String s, int x, int y) {
    Stack<Character> stack1 = new Stack<>();
    Stack<Character> stack2 = new Stack<>();
    int maxScore = 0;

    // When "ab" scores more than "ba", we can reverse string `s` to maintain the logic
    if (x > y) {
      int temp = x;
      x = y;
      y = temp;
      s = new StringBuilder(s).reverse().toString();
    }

    // Process 'ba' first
    for (char c: s.toCharArray()) {
      if (c == 'a' && !stack1.isEmpty() && stack1.peek() == 'b') {
        stack1.pop();
        maxScore += y;
      } else {
        stack1.push(c);
      }
    }

    // Process 'ab'
    while (!stack1.isEmpty()) {
      char c = stack1.pop();

      if (c == 'a' && !stack2.isEmpty() && stack2.peek() == 'b') {
        stack2.pop();
        maxScore += x;
      } else {
        stack2.push(c);
      }
    }

    return maxScore;
  }
}

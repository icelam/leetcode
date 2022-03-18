class Solution {
  public String smallestSubsequence(String s) {
    Stack<Character> stack = new Stack();
    int[] count = new int[26];
    boolean[] added = new boolean[26];

    for (int i = 0; i < s.length(); i++) {
      count[s.charAt(i) - 'a']++;
    }

    for (int i = 0; i < s.length(); i++) {
      if (!added[s.charAt(i) - 'a']) {
        while (
          !stack.empty() && stack.peek() - 'a' >= s.charAt(i) - 'a'
          && count[stack.peek() - 'a'] > 1
        ) {
          char removed = stack.pop();
          added[removed - 'a'] = false;
          count[removed - 'a']--;
        }

        stack.push(s.charAt(i));
        added[s.charAt(i) - 'a'] = true;
      } else {
        count[s.charAt(i) - 'a']--;
      }
    }

    StringBuilder result = new StringBuilder();
    while (!stack.empty()) {
      result.append(stack.pop());
    }

    return result.reverse().toString();
  }
}

class Solution {
  public int scoreOfParentheses(String s) {
    int depth = 0;
    int result = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        depth++;
      } else {
        depth--;

        if (s.charAt(i - 1) == '(') {
          result += Math.pow(2, depth);
        }
      }
    }

    return result;
  }
}

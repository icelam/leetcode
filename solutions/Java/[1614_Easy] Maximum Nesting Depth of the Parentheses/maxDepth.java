class Solution {
  public int maxDepth(String s) {
    int open = 0;
    int maxDepth = 0;

    for (char c: s.toCharArray()) {
      if (c == ')') {
        open--;
        continue;
      }

      if (c == '(') {
        open++;
        maxDepth = Math.max(maxDepth, open);
      }
    }

    return maxDepth;
  }
}

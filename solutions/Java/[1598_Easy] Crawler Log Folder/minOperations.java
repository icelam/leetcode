class Solution {
  public int minOperations(String[] logs) {
    int depth = 0;

    for (String operation: logs) {
      if (operation.equals("../")) {
        depth = Math.max(0, depth - 1);
      } else if (!operation.equals("./")) {
        depth++;
      }
    }

    return depth;
  }
}

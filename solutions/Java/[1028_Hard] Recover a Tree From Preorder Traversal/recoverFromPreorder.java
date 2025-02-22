class Solution {
  public TreeNode recoverFromPreorder(String traversal) {
    char[] nodes = traversal.toCharArray();
    int n = nodes.length;
    int index = 0;
    Stack<TreeNode> stack = new Stack<>();

    while (index < n) {
      int depth = 0;

      while (index < n && nodes[index] == '-') {
        depth++;
        index++;
      }

      int value = 0;

      while (index < n && Character.isDigit(nodes[index])) {
        value = value * 10 + (nodes[index] - '0');
        index++;
      }

      TreeNode node = new TreeNode(value);

      while (stack.size() > depth) {
        stack.pop();
      }

      if (!stack.empty()) {
        if (stack.peek().left == null) {
          stack.peek().left = node;
        } else {
          stack.peek().right = node;
        }
      }

      stack.push(node);
    }

    while (stack.size() > 1) {
      stack.pop();
    }

    return stack.peek();
  }
}

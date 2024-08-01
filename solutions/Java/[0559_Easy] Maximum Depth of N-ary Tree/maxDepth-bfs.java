class Solution {
  public int maxDepth(Node root) {
    if (root == null) {
      return 0;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    int depth = 0;

    while (!queue.isEmpty()) {
      depth++;

      for (int i = queue.size(); i > 0; i--) {
        for (Node child: queue.remove().children) {
          queue.add(child);
        }
      }
    }

    return depth;
  }
}

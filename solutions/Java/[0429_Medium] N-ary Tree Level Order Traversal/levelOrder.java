/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      List<Integer> level = new ArrayList<>();
      int levelSize = queue.size();

      for (int i = 0; i < levelSize; i++) {
        Node current = queue.remove();
        level.add(current.val);

        for (int j = 0; j < current.children.size(); j++) {
          queue.add(current.children.get(j));
        }
      }

      result.add(level);
    }

    return result;
  }
}

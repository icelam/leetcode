/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }

    HashMap<Integer, Node> clonedNodes = new HashMap<>();
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);

    Node root = null;

    while (!queue.isEmpty()) {
      Node current = queue.remove();
      Node newCurrent = clonedNodes.containsKey(current.val)
        ? clonedNodes.get(current.val)
        : new Node(current.val);

      for (Node neighbor: current.neighbors) {
        if (!clonedNodes.containsKey(neighbor.val)) {
          queue.add(neighbor);
          clonedNodes.put(neighbor.val, new Node(neighbor.val));
        }

        newCurrent.neighbors.add(clonedNodes.get(neighbor.val));
      }

      clonedNodes.put(current.val, newCurrent);

      if (root == null) {
        root = newCurrent;
      }
    }

    return root;
  }
}

class Node {
  private int value;
  private List<Node> neighbor;

  public Node(int n) {
    this.value = n;
    this.neighbor = new ArrayList<Node>();
  }

  public void createEdge(Node neighborNode) {
    this.neighbor.add(neighborNode);
    neighborNode.neighbor.add(this);
  }

  public List<Node> getChildren() {
    return this.neighbor;
  }

  public int getValue() {
    return this.value;
  }
}

class Solution {
  private int[] result;
  private int[] count;

  public void postOrder(Node node, Node parent) {
    int currentValue = node.getValue();
    int parentValue = parent.getValue();

    for (Node childNode: node.getChildren()) {
      int childValue = childNode.getValue();

      if (childValue != parentValue) {
        postOrder(childNode, node);
        count[currentValue] += count[childValue];
        result[currentValue] += result[childValue] + count[childValue];
      }
    }
  }

  public void preOrder(Node node, Node parent, int n) {
    int currentValue = node.getValue();
    int parentValue = parent.getValue();

    for (Node childNode: node.getChildren()) {
      int childValue = childNode.getValue();

      if (childValue != parentValue) {
        result[childValue] = result[currentValue] - count[childValue] + n - count[childValue];
        preOrder(childNode, node, n);
      }
    }
  }

  public int[] sumOfDistancesInTree(int n, int[][] edges) {
    Node[] nodes = new Node[n];
    result = new int[n];
    count = new int[n];
    Arrays.fill(count, 1);

    for (int i = 0; i < n; i++) {
      nodes[i] = new Node(i);
    }

    for (int i = 0; i < edges.length; i++) {
      int node1 = edges[i][0];
      int node2 = edges[i][1];
      nodes[node1].createEdge(nodes[node2]);
    }

    postOrder(nodes[0], new Node(-1));
    preOrder(nodes[0], new Node(-1), n);

    return result;
  }
}

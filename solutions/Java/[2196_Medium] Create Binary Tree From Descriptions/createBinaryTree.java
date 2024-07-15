class Solution {
  public TreeNode createBinaryTree(int[][] descriptions) {
    HashMap<Integer, TreeNode> map = new HashMap<>();
    HashSet<Integer> children = new HashSet<>();

    for (int[] description : descriptions) {
      TreeNode parentNode = map.computeIfAbsent(description[0], value -> new TreeNode(description[0]));
      TreeNode currentNode = map.computeIfAbsent(description[1], value -> new TreeNode(description[1]));

      if (description[2] == 1) {
        parentNode.left = currentNode;
      } else {
        parentNode.right = currentNode;
      }

      children.add(description[1]);
    }

    for (TreeNode node: map.values()) {
      if (!children.contains(node.val)) {
        return node;
      }
    }

    return null;
  }
}

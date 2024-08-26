class Solution {
  public void traverse(Node root, List<Integer> list) {
    if (root != null) {
      for (Node child: root.children) {
        traverse(child, list);
      }

      list.add(root.val);
    }
  }

  public List<Integer> postorder(Node root) {
    List<Integer> result = new ArrayList<>();
    traverse(root, result);
    return result;
  }
}

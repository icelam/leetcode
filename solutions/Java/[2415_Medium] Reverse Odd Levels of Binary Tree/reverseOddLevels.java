class Solution {
  public TreeNode reverseOddLevels(TreeNode root) {
    int level = 0;
    TreeNode[] levelNodes = new TreeNode[(int) Math.pow(2, level)];
    levelNodes[0] = root;

    while (levelNodes[0] != null) {
      int levelCount = (int) (Math.pow(2, level));
      int nextLevelCount = (int) (Math.pow(2, level + 1));
      TreeNode[] nextLevelNodes = new TreeNode[nextLevelCount];

      for (int i = 0; i < levelCount; i++) {
        nextLevelNodes[i * 2] = levelNodes[i].left;
        nextLevelNodes[i * 2 + 1] = levelNodes[i].right;
      }

      for (int i = 0; i < levelCount; i++) {
        TreeNode newLeftNode = nextLevelNodes[nextLevelCount - 1 - (i * 2)];
        TreeNode newRightNode = nextLevelNodes[nextLevelCount - 1 - (i * 2 + 1)];

        if (level % 2 == 0) {
          TreeNode tempNode = null;

          if (newLeftNode != null) {
            tempNode = newLeftNode.left;
            newLeftNode.left = newLeftNode.right;
            newLeftNode.right = tempNode;
          }

          if (newLeftNode != null) {
            tempNode = newRightNode.left;
            newRightNode.left = newRightNode.right;
            newRightNode.right = tempNode;
          }
        }

        levelNodes[i].left = newLeftNode;
        levelNodes[i].right = newRightNode;
      }

      level++;
      levelNodes = nextLevelNodes;
    }

    return root;
  }
}

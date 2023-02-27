/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
  public boolean isSameValue(int[][] grid, int size, int row, int column) {
    for (int currentRow = row; currentRow < row + size; currentRow++) {
      for (int currentColumn = column; currentColumn < column + size; currentColumn++) {
        if (grid[currentRow][currentColumn] != grid[row][column]) {
          return false;
        }
      }
    }

    return true;
  }
  public Node buildQuadTree(int[][] grid, int size, int row, int column) {
    if (isSameValue(grid, size, row, column)) {
      return new Node(grid[row][column] == 1, true);
    }

    Node root = new Node();
    int newSize = size / 2;

    root.topLeft = buildQuadTree(grid, newSize, row, column);
    root.topRight = buildQuadTree(grid, newSize, row, column + newSize);
    root.bottomLeft = buildQuadTree(grid, newSize, row + newSize, column);
    root.bottomRight = buildQuadTree(grid, newSize, row + newSize, column + newSize);

    return root;
  }

  public Node construct(int[][] grid) {
    return buildQuadTree(grid, grid.length, 0, 0);
  }
}

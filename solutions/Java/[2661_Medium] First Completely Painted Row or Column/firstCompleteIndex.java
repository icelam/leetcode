class Solution {
  public int firstCompleteIndex(int[] arr, int[][] mat) {
    int height = mat.length;
    int width = mat[0].length;

    HashMap<Integer, int[]> positions = new HashMap<>();

    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        positions.put(mat[row][column], new int[]{row, column});
      }
    }

    int[] rowFillCount = new int[height];
    int[] columnFillCount = new int[width];

    for (int i = 0; i < arr.length; i++) {
      int[] currentPosition = positions.get(arr[i]);
      rowFillCount[currentPosition[0]]++;
      columnFillCount[currentPosition[1]]++;

      if (rowFillCount[currentPosition[0]] == width || columnFillCount[currentPosition[1]] == height) {
        return i;
      }
    }

    return -1;
  }
}

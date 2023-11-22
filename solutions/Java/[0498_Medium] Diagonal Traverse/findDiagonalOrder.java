class Solution {
  public int[] findDiagonalOrder(int[][] mat) {
    int height = mat.length;
    int width = mat[0].length;
    int diagonalCount = height + width - 1;

    ArrayList<Integer>[] reorderedNums = new ArrayList[diagonalCount];

    for (int i = 0; i < diagonalCount; i++) {
      reorderedNums[i] = new ArrayList<Integer>();
    }

    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        reorderedNums[column + row].add(mat[row][column]);
      }
    }

    int[] result = new int[height * width];
    int pointer = 0;

    for (int i = 0; i < diagonalCount; i++) {
      List<Integer> batch = reorderedNums[i];
      int batchSize = batch.size();
      boolean shouldReverse = i % 2 == 0;
      int j = shouldReverse ? batchSize - 1 : 0;

      while (j >= 0 && j < batchSize) {
        result[pointer] = batch.get(j);
        pointer++;

        if (shouldReverse) {
          j--;
        } else {
          j++;
        }
      }
    }

    return result;
  }
}

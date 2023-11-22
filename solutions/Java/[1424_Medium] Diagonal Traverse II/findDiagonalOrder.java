class Solution {
  public int[] findDiagonalOrder(List<List<Integer>> nums) {
    int height = nums.size();
    int width = 0;
    int n = 0;

    for (int i = 0; i < height; i++) {
      int rowSize = nums.get(i).size();
      width = Math.max(width, rowSize);
      n += rowSize;
    }

    int diagonalCount = height + width - 1;
    ArrayList<Integer>[] reorderedNums = new ArrayList[diagonalCount];

    for (int i = 0; i < diagonalCount; i++) {
      reorderedNums[i] = new ArrayList<Integer>();
    }

    for (int row = height - 1; row >= 0; row--) {
      List<Integer> rowList = nums.get(row);
      int rowSize = rowList.size();

      for (int column = 0; column < rowSize; column++) {
        reorderedNums[column + row].add(rowList.get(column));
      }
    }

    int[] result = new int[n];
    int pointer = 0;

    for (List<Integer> batch: reorderedNums) {
      for (int value: batch) {
        result[pointer] = value;
        pointer++;
      }
    }

    return result;
  }
}

class Solution {
  public List<List<Integer>> shiftGrid(int[][] grid, int k) {
    int rowSize = grid.length;
    int columnSize = grid[0].length;
    int size = rowSize * columnSize;

    int[][] result = new int[rowSize][columnSize];

    k = k % size;

    for (int i = 0; i < size; i++) {
      int index = (size + i - k) % size;
      result[i / columnSize][i % columnSize] = grid[index / columnSize][index % columnSize];
    }

    return Arrays.stream(result)
      .map(a -> IntStream.of(a).boxed().collect(Collectors.toList()))
      .collect(Collectors.toList());
  }
}

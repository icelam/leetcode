class Solution {
  private boolean canCut(int[][] rectangles, int coordinate) {
    Arrays.sort(rectangles, (a, b) -> a[coordinate] - b[coordinate]);

    int max = rectangles[0][coordinate == 0 ? 2 : 3];
    int cutCount = 0;

    for (int i = 1; i < rectangles.length; i++) {
      int[] currentRectangle = rectangles[i];

      if (max <= currentRectangle[coordinate]) {
        cutCount++;
      }

      max = Math.max(max, currentRectangle[coordinate + 2]);
    }

    return cutCount >= 2;
  }

  public boolean checkValidCuts(int n, int[][] rectangles) {
    return canCut(rectangles, 0) || canCut(rectangles, 1);
  }
}

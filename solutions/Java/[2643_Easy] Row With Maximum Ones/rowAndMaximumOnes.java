class Solution {
  public int[] rowAndMaximumOnes(int[][] mat) {
    int n = mat.length;
    int leastRowIndex = 0;
    int maxCount = 0;

    for (int i = 0; i < n; i++) {
      int currentCount = 0;

      for (int value: mat[i]) {
        currentCount += value;
      }

      if (currentCount > maxCount) {
        leastRowIndex = i;
        maxCount = currentCount;
      }
    }

    return new int[]{leastRowIndex, maxCount};
  }
}

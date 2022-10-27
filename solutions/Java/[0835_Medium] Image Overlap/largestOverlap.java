class Solution {
  public int largestOverlap(int[][] img1, int[][] img2) {
    int size = img1.length;
    int max = 0;

    for (int offsetX = -size + 1; offsetX < size; offsetX++) {
      for (int offsetY = -size + 1; offsetY < size; offsetY++) {
        int operlap = 0;

        for (int i = Math.max(-offsetX, 0); i < size + Math.min(-offsetX, 0); i++) {
          for (int j = Math.max(-offsetY, 0); j < size + Math.min(-offsetY, 0); j++) {
            if (img1[i][j] == 1 && img1[i][j] == img2[i + offsetX][j + offsetY]) {
              operlap++;
            }
          }
        }

        max = Math.max(max, operlap);
      }
    }

    return max;
  }
}

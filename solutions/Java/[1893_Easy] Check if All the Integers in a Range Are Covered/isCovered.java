class Solution {
  public boolean isCovered(int[][] ranges, int left, int right) {
    boolean[] isSeen = new boolean[51];

    for (int[] r: ranges) {
      for (int i = r[0]; i <= r[1]; i++) {
        isSeen[i] = true;
      }
    }

    for (int i = left; i <= right; i++) {
      if (!isSeen[i]) {
        return false;
      }
    }

    return true;
  }
}

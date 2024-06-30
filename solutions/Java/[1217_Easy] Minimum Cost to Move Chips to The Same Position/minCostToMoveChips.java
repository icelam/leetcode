class Solution {
  public int minCostToMoveChips(int[] position) {
    int[] frequency = new int[2];

    for (int p : position) {
      frequency[p % 2]++;
    }

    return Math.min(frequency[0], frequency[1]);
  }
}

class Solution {
  public int findJudge(int n, int[][] trust) {
    // [0] = trusting count (out degree), [1] = trust by count (in degree)
    int[][] trustCount = new int[n + 1][2];

    for (int[] relationship: trust) {
      trustCount[relationship[0]][0]++;
      trustCount[relationship[1]][1]++;
    }

    for (int i = 1; i <= n; i++) {
      if (trustCount[i][0] == 0 && trustCount[i][1] == n - 1) {
        return i;
      }
    }

    return -1;
  }
}

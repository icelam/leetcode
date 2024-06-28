class Solution {
  public long maximumImportance(int n, int[][] roads) {
    int[] outdegree = new int[n];
    long importance = 0;

    for (int[] r: roads) {
      outdegree[r[0]]++;
      outdegree[r[1]]++;
    }

    Arrays.sort(outdegree);

    for (int i = 0; i < n; i++) {
      importance += (long) outdegree[i] * (i + 1);
    }

    return importance;
  }
}

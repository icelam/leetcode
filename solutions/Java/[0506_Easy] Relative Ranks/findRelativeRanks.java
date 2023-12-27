class Solution {
  public String[] findRelativeRanks(int[] score) {
    int n = score.length;
    int[][] scoreIndexPairs = new int[n][2];

    for (int i = 0; i < n; i++) {
      scoreIndexPairs[i][0] = score[i];
      scoreIndexPairs[i][1] = i;
    }

    Arrays.sort(scoreIndexPairs, (a, b) -> b[0] - a[0]);

    String[] result = new String[n];

    for (int i = 0; i < n; i++) {
      if (i >= 3) {
        result[scoreIndexPairs[i][1]] = Integer.toString(i + 1);
      } else if (i == 0) {
        result[scoreIndexPairs[i][1]] = "Gold Medal";
      } else if (i == 1) {
        result[scoreIndexPairs[i][1]] = "Silver Medal";
      } else if (i == 2) {
        result[scoreIndexPairs[i][1]] = "Bronze Medal";
      }
    }

    return result;
  }
}

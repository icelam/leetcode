class Solution {
  public int maxEnvelopes(int[][] envelopes) {
    Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

    int result = 0;
    int[] dp = new int[envelopes.length];

    for (int[] e: envelopes) {
      int height = e[1];
      int left = Arrays.binarySearch(dp, 0, result, height);

      // Not found, Arrays.binarySearch return the insertion point
      if (left < 0) {
        left = -left - 1;
      }

      if (left == result) {
        result++;
      }

      dp[left] = height;
    }

    return result;
  }
}

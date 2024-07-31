class Solution {
  public int minHeightShelves(int[][] books, int shelfWidth) {
    int n = books.length;
    int[] dp = new int[n + 1];

    Arrays.fill(dp, Integer.MAX_VALUE / 2);
    dp[0] = 0;

    for (int i = 0; i < n; i++) {
      int maxHeight = 0;
      int currentWidth = 0;

      for (int j = i; j >= 0; j--) {
        currentWidth += books[j][0];

        if (currentWidth > shelfWidth) {
          break;
        }

        maxHeight = Math.max(maxHeight, books[j][1]);
        dp[i + 1] = Math.min(dp[i + 1], dp[j] + maxHeight);
      }
    }

    return dp[n];
  }
}

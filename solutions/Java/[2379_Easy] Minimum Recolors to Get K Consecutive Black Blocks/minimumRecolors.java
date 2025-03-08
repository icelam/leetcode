class Solution {
  public int minimumRecolors(String blocks, int k) {
    char[] blackOrWhite = blocks.toCharArray();
    int n = blackOrWhite.length;
    int whiteCount = 0;

    for (int i = 0; i < k; i++) {
      // B = 66, W = 87 in ASCII
      whiteCount += blackOrWhite[i] % 2;
    }

    int minWhiteCount = whiteCount;

    for (int i = k; i < n; i++) {
      whiteCount += (blackOrWhite[i] % 2) - (blackOrWhite[i - k] % 2);
      minWhiteCount = Math.min(minWhiteCount, whiteCount);
    }

    return minWhiteCount;
  }
}

class Solution {
  public int hammingDistance(int x, int y) {
    int hammingDistance = 0;

    for (int i = 0; i < 32 && (x > 0 || y > 0); i++) {
      int lastBitOfX = x & 1;
      int lastBitOfY = y & 1;

      if (lastBitOfX != lastBitOfY) {
        hammingDistance++;
      }

      x >>= 1;
      y >>= 1;
    }

    return hammingDistance;
  }
}

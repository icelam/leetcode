class Solution {
  private static int MOD = 1_000_000_007;

  public int concatenatedBinary(int n) {
    long result = 0;

    for (int i = 1; i <= n; i++) {
      int num = i;

      while (num != 0) {
        num >>= 1;
        result <<= 1;
      }

      result = (result + i) % MOD;
    }

    return (int) result;
  }
}

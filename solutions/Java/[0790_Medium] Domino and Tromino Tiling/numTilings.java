class Solution {
  private static int MOD = (int) 1e9 + 7;

  public int numTilings(int n) {
    if (n <= 2) {
      return n;
    }

    long[] f = new long[n + 1];
    f[0] = 1;
    f[1] = 1;
    f[2] = 2;

    for (int i = 3; i <= n; i++) {
      f[i] = (f[i - 1] * 2 + f[i - 3]) % MOD;
    }

    return (int) f[n];
  }
}

class Solution {
  private static final long MOD = (long) 1e9 + 7;

  public int countVowelPermutation(int n) {
    long a, e, i, o, u;
    a = e = i = o = u = 1;

    long aSuffixCount, eSuffixCount, iSuffixCount, oSuffixCount, uSuffixCount;
    aSuffixCount = eSuffixCount = iSuffixCount = oSuffixCount = uSuffixCount = 1;

    while (--n > 0) {
      aSuffixCount = e % MOD;
      eSuffixCount = (a + i) % MOD;
      iSuffixCount = (a + e + o + u) % MOD;
      oSuffixCount = (i + u) % MOD;
      uSuffixCount = a % MOD;

      a = aSuffixCount;
      e = eSuffixCount;
      i = iSuffixCount;
      o = oSuffixCount;
      u = uSuffixCount;
    }

    return (int) ((a + e + i + o + u) % MOD);
  }
}

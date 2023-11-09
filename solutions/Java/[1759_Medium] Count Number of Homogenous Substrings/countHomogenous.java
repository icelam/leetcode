class Solution {
  private static int MOD = (int) (1e9 + 7);

  public long arithmeticSum(int n) {
    long result = ((long) n * (n + 1)) / 2;
    return result % MOD;
  }

  public int countHomogenous(String s) {
    char[] characters = s.toCharArray();
    int n = characters.length;
    int result = 0;
    int start = 0;

    for (int i = 0; i < n; i++) {
      if (i > 0 && characters[i] != characters[i - 1]) {
        result += arithmeticSum(i - start);
        result %= MOD;
        start = i;
      }
    }

    result += arithmeticSum(n - start);
    result %= MOD;
    return result;
  }
}

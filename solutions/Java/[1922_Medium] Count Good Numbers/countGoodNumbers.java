class Solution {
  private static int MOD = (int) (1e9 + 7);

  public long fastExponentiation(long base, long exponent) {
    long result = 1;

    while (exponent > 0) {
      if (exponent % 2 == 1) {
        result = (result * base) % MOD;
      }

      base = (base * base) % MOD;
      exponent /= 2;
    }

    return result;
  }

  public int countGoodNumbers(long n) {
    // Since the maximum value of n can reach 10^15, directly calculating the power in the formula
    // using ordinary multiplication would exceed the time limit. Use fast exponentiation algorithm
    // to optimize the calculation of x^y % mod
    return (int) ((fastExponentiation(5, (n + 1) / 2) * fastExponentiation(4, n / 2)) % MOD);
  }
}

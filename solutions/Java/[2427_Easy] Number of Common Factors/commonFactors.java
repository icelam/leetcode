class Solution {
  private int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  public int commonFactors(int a, int b) {
    int n = gcd(a, b);
    double m = Math.sqrt(n);
    int result = 0;

    for (int i = 1; i <= m; i++) {
      if (n % i == 0) {
        result += (n / i == i) ? 1 : 2;
      }
    }

    return result;
  }
}

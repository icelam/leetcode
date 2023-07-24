class Solution {
  private double power(double x, long exponent) {
    if (exponent == 0) {
      return 1;
    }

    if (exponent == 1) {
      return x;
    }

    if (exponent < 0) {
      return power(1 / x, exponent * -1);
    }

    double result = power(x * x, exponent / 2);

    if (exponent % 2 == 1) {
      result *= x;
    }

    return result;
  }

  public double myPow(double x, int n) {
    return power(x, n);
  }
}

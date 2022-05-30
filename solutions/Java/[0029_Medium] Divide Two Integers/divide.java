class Solution {
  public int divide(int dividend, int divisor) {
    // Special handling for overflow case where
    // -2147483648 / -1 = 2147483648 which exceed Integer.MAX_VALUE
    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE;
    }

    int sign = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0) ? -1 : 1;
    int quotient = 0;

    // Integer range: -2^31 to 2^31 - 1 (-2147483648 to 2147483647)
    // Convert to long in case dividend / divisor is Integer.MIN_VALUE
    long absoluteDividend = Math.abs((long) dividend);
    long absoluteDivisor = Math.abs((long) divisor);

    while (absoluteDividend >= absoluteDivisor) {
      int shift = 0;

      // perform << n to absoluteDivisor which is equals to
      // absoluteDivisor * 2^n
      while (absoluteDividend >= (absoluteDivisor << (shift + 1))) {
        shift++;
      }

      quotient += 1 << shift;
      absoluteDividend -= absoluteDivisor << shift;
    }

    return sign == -1 ? -quotient : quotient;
  }
}

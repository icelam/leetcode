class Solution {
  public String thousandSeparator(int n) {
    if (n == 0) {
      return "0";
    }

    StringBuilder builder = new StringBuilder();
    int digitCount = 0;

    while (n > 0) {
      builder.append(n % 10);
      digitCount++;
      n /= 10;

      if (n > 0 && digitCount % 3 == 0) {
        builder.append('.');
      }
    }

    return builder.reverse().toString();
  }
}

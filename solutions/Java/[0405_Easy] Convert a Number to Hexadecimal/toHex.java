class Solution {
  public String toHex(int num) {
    if (num == 0) {
      return "0";
    }

    long n = num;
    StringBuilder builder = new StringBuilder();

    if (n < 0) {
      n = (long) Math.pow(2, 32) + n;
    }

    while (n != 0) {
      long remainder = n % 16;

      if (remainder >= 10) {
        builder.insert(0, (char) ('a' + (remainder - 10)));
      } else {
        builder.insert(0, (char) ('0' + remainder));
      }

      n /= 16;
    }

    return builder.toString();
  }
}

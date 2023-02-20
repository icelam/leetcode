class Solution {
  public String convertToBase7(int num) {
    if (num == 0) {
      return "0";
    }

    int n = Math.abs(num);
    int sign = num < 0 ? -1 : 1;

    StringBuilder result = new StringBuilder();

    while (n > 0) {
      result.append(n % 7);
      n /= 7;
    }

    if (sign == -1) {
      result.append('-');
    }

    return result.reverse().toString();
  }
}

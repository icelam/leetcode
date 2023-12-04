class Solution {
  public String largestGoodInteger(String num) {
    char[] digits = num.toCharArray();
    char previousDigit = digits[0];
    int streak = 0;
    int maxDigit = -1;

    for (char digit: digits) {
      if (digit != previousDigit) {
        previousDigit = digit;
        streak = 0;
      }

      streak++;

      if (streak == 3 && maxDigit < digit - '0') {
        maxDigit = digit - '0';
      }
    }

    if (maxDigit == -1) {
      return "";
    }

    return Integer.toString(maxDigit).repeat(3);
  }
}

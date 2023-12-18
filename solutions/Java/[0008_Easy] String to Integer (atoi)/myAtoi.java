class Solution {
  public int myAtoi(String s) {
    char[] characters = s.toCharArray();
    int n = characters.length;
    int i = 0;
    boolean isNegative = false;
    long result = 0;

    while (i < n && characters[i] == ' ') {
      i++;
    }

    if (i < n  && (characters[i] == '-' || characters[i] == '+')) {
      isNegative = characters[i] == '-';
      i++;
    }

    while (i < n && result < Integer.MAX_VALUE && Character.isDigit(characters[i])) {
      result *= 10;
      result += characters[i] - '0';
      i++;
    }

    if (isNegative) {
      result *= -1;
    }

    if (result < Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }

    if (result > Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    }

    return (int) result;
  }
}

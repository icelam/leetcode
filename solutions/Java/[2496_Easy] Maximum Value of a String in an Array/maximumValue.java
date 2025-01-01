class Solution {
  private boolean isIntegerString(String s) {
    for (char c: s.toCharArray()) {
      if (!Character.isDigit(c)) {
        return false;
      }
    }

    return true;
  }

  private int toNumber(String s) {
    int result = 0;

    for (char c: s.toCharArray()) {
      result = result * 10 + (c - '0');
    }

    return result;
  }

  public int maximumValue(String[] strs) {
    int max = Integer.MIN_VALUE;

    for (String s: strs) {
      if (isIntegerString(s)) {
        max = Math.max(max, toNumber(s));
      } else {
        max = Math.max(max, s.length());
      }
    }

    return max;
  }
}

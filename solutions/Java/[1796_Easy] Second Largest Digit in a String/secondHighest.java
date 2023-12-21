class Solution {
  public int secondHighest(String s) {
    int largestDigit = -1;
    int secondLargestDigit = -1;

    for (char c: s.toCharArray()) {
      if (!Character.isDigit(c)) {
        continue;
      }

      int digit = c - '0';

      if (digit > largestDigit) {
        secondLargestDigit = largestDigit;
        largestDigit = digit;
        continue;
      }

      if (digit == largestDigit) {
        continue;
      }

      if (digit > secondLargestDigit) {
        secondLargestDigit = digit;
      }
    }

    return secondLargestDigit;
  }
}

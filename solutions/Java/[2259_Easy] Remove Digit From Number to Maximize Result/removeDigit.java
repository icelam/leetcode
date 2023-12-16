class Solution {
  public String removeDigit(String number, char digit) {
    int n = number.length();
    StringBuilder builder = new StringBuilder(number);
    int indexToRemove = -1;

    for (int i = 0; i < n; i++) {
      if (number.charAt(i) == digit) {
        indexToRemove = i;

        if (i + 1 != n && number.charAt(i) < number.charAt(i + 1)) {
          break;
        }
      }
    }

    builder.deleteCharAt(indexToRemove);
    return builder.toString();
  }
}

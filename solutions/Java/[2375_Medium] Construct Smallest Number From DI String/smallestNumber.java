class Solution {
  public String smallestNumber(String pattern) {
    char[] characters = pattern.toCharArray();
    int n = characters.length;
    int[] result = new int[n + 1];
    int i = 0;
    int currentDigit = 1;

    while (i < n) {
      if (i > 0 && characters[i] == 'I') {
        i++;
      }

      // Find consecutive 'I'
      while (i < n && characters[i] == 'I') {
        result[i] = currentDigit;
        currentDigit++;
        i++;
      }

      int start = i;

      // Find consecutive 'D'
      while (i < n && characters[i] == 'D') {
        i++;
      }

      // Reverse fill
      for (int end = i; end >= start; end--) {
        result[end] = currentDigit;
        currentDigit++;
      }
    }

    StringBuilder builder = new StringBuilder();

    for (int digit : result) {
      builder.append((char) ('0' + digit));
    }

    return builder.toString();
  }
}

class Solution {
  public String maximumOddBinaryNumber(String s) {
    int[] counts = new int[2];

    for (char c: s.toCharArray()) {
      counts[c - '0']++;
    }

    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < counts[1] - 1; i++) {
      builder.append('1');
    }

    for (int i = 0; i < counts[0]; i++) {
      builder.append('0');
    }

    builder.append('1');

    return builder.toString();
  }
}

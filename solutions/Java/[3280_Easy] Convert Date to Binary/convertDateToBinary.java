class Solution {
  public String convertDateToBinary(String date) {
    char[] characters = date.toCharArray();

    int[] dateParts = new int[3];
    int index = 0;

    for (char c: characters) {
      if (c == '-') {
        index++;
        continue;
      }

      dateParts[index] *= 10;
      dateParts[index] += c - '0';
    }

    StringBuilder result = new StringBuilder();

    for (int value: dateParts) {
      if (result.length() > 0) {
        result.append("-");
      }

      StringBuilder builder = new StringBuilder();

      while (value > 0) {
        builder.insert(0, value & 1);
        value >>= 1;
      }

      result.append(builder.toString());
    }

    return result.toString();
  }
}

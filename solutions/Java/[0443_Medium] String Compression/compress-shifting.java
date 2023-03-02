class Solution {
  public char[] convertIntToChar(int n) {
    return Integer.toString(n).toCharArray();
  }

  public int compress(char[] chars) {
    int start = 0;
    int end = chars.length - 1;

    while (start <= end) {
      int current = start;

      while (current <= end && chars[start] == chars[current]) {
        current++;
      }

      int count = current - start;

      if (count <= 1) {
        start = current;
        continue;
      }

      char[] compressionValue = convertIntToChar(current - start);
      int offset = compressionValue.length;

      for (int i = 1; i <= offset; i++) {
        chars[start + i] = compressionValue[i - 1];
      }

      for (int i = 0; current + i <= end; i++) {
        chars[start + offset + i + 1] = chars[current + i];
      }

      start += offset + 1;
      end -= count - offset - 1;
    }

    return end + 1;
  }
}

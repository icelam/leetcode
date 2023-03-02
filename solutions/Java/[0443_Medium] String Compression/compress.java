class Solution {
  public char[] convertIntToChar(int n) {
    return Integer.toString(n).toCharArray();
  }

  public int compress(char[] chars) {
    int read = 0;
    int write = 0;
    int length = chars.length;

    while (read < length) {
      int count = 1;

      while (read + count < length && chars[read + count] == chars[read]) {
        count++;
      }

      chars[write++] = chars[read];
      read += count;

      if (count <= 1) {
        continue;
      }

      for (char n: convertIntToChar(count)) {
        chars[write++] = n;
      }
    }

    return write;
  }
}

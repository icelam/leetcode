class Solution {
  public int[] numberOfLines(int[] widths, String s) {
    int lineWidth = 0;
    int lineCount = 1;

    for (Character c: s.toCharArray()) {
      int charWidth = widths[c - 'a'];

      if (lineWidth + charWidth > 100) {
        lineCount++;
        lineWidth = 0;
      }

      lineWidth += charWidth;
    }

    return new int[]{lineCount, lineWidth};
  }
}

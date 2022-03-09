class Solution {
  public char findTheDifference(String s, String t) {
    int sSum = 0;
    int xSum = 0;

    for (int i = 0; i < Math.max(s.length(), t.length()); i++) {
      if (i < s.length()) {
        sSum ^= s.charAt(i);
      }

      if (i < t.length()) {
        xSum ^= t.charAt(i);
      }
    }

    return (char) (sSum ^ xSum);
  }
}

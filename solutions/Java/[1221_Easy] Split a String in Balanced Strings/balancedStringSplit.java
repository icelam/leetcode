class Solution {
  public int balancedStringSplit(String s) {
    int countL = 0;
    int countR = 0;
    int split = 0;

    for (char c: s.toCharArray()) {
      if (c == 'L') {
        countL++;
      } else {
        countR++;
      }

      if (countL != 0 && countL == countR) {
        split++;
        countL = 0;
        countR = 0;
      }
    }

    return split;
  }
}

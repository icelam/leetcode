class Solution {
  public int getPreviousCharIndex(String str, int index) {
    int skip = 0;

    while (index >= 0 && (str.charAt(index) == '#' || skip > 0)) {
      skip += str.charAt(index) == '#' ? 1 : -1;
      index--;
    }

    return index;
  }

  public boolean backspaceCompare(String s, String t) {
    int i = s.length() - 1;
    int j = t.length() - 1;

    while (i >= 0 || j >= 0) {
      i = getPreviousCharIndex(s, i);
      j = getPreviousCharIndex(t, j);

      if (
        (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j))
        || (i >= 0 && j < 0)
        || (i < 0 && j >= 0)
      ) {
        return false;
      }

      i--;
      j--;
    }

    return true;
  }
}

class Solution {
  public boolean rotateString(String s, String goal) {
    int m = s.length();
    int n = goal.length();

    if (m != n) {
      return false;
    }

    char[] original = s.toCharArray();
    char[] expected = goal.toCharArray();

    for (int i = 0; i < m; i++) {
      boolean isEqual = true;

      for (int j = i; j < m + i && isEqual; j++) {
        isEqual &= expected[j % m] == original[j - i];
      }

      if (isEqual) {
        return true;
      }
    }

    return false;
  }
}

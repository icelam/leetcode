class Solution {
  private boolean isValid = false;
  private boolean[][] hasVisited;

  private void bruteForce(char[] c1, char[] c2, char[] c3, char[] buffer, int p1, int p2, int p3) {
    if (c1.length + c2.length == p3 && !isValid) {
      isValid = String.valueOf(buffer).equals(String.valueOf(c3));
      return;
    }

    if (isValid) {
      return;
    }

    if (p1 < c1.length && c1[p1] == c3[p3] && !hasVisited[p1 + 1][p2]) {
      hasVisited[p1 + 1][p2] = true;
      buffer[p3] = c1[p1];
      bruteForce(c1, c2, c3, buffer, p1 + 1, p2, p3 + 1);
    }

    if (p2 < c2.length && c2[p2] == c3[p3] && !hasVisited[p1][p2 + 1]) {
      hasVisited[p1][p2 + 1] = true;
      buffer[p3] = c2[p2];
      bruteForce(c1, c2, c3, buffer, p1, p2 + 1, p3 + 1);
    }
  }

  public boolean isInterleave(String s1, String s2, String s3) {
    int length1 = s1.length();
    int length2 = s2.length();
    int length3 = s3.length();

    hasVisited = new boolean[length1 + 1][length2 + 1];

    if (length1 + length2 != length3) {
      return false;
    }

    if (length1 + length2 + length3 == 0) {
      return true;
    }

    char[] buffer = new char[length3];
    Arrays.fill(buffer, '-');

    bruteForce(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), buffer, 0, 0, 0);
    return isValid;
  }
}

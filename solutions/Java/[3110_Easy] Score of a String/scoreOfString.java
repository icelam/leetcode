class Solution {
  public int scoreOfString(String s) {
    char[] chaaracters = s.toCharArray();
    int n = chaaracters.length;
    int result = 0;

    for (int i = 1; i < n; i++) {
      result += Math.abs(chaaracters[i - 1] - chaaracters[i]);
    }

    return result;
  }
}

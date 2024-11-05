class Solution {
  public int minChanges(String s) {
    int result = 0;
    int n = s.length();
    char[] characters = s.toCharArray();

    for (int i = 0; i < n; i += 2) {
      if (characters[i] != characters[i + 1]) {
        result++;
      }
    }

    return result;
  }
}

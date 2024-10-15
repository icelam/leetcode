class Solution {
  public long minimumSteps(String s) {
    int n = s.length();
    char[] characters = s.toCharArray();
    int boundary = 0;
    long result = 0;

    for (int i = 0; i < n; i++) {
      if (characters[i] == '0') {
        result += i - boundary;
        boundary++;
      }
    }

    return result;
  }
}

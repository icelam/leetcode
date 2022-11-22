class Solution {
  public boolean checkString(String s) {
    int n = s.length();
    int firstIndexOfB = Integer.MAX_VALUE;
    int lastIndexOfA = -1;

    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      if (c == 'a') {
        lastIndexOfA = i;
      }

      if (c == 'b' && firstIndexOfB == Integer.MAX_VALUE) {
        firstIndexOfB = i;
      }
    }

    return firstIndexOfB > lastIndexOfA;
  }
}

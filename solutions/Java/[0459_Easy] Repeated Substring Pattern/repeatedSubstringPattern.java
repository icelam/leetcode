class Solution {
  public boolean repeatedSubstringPattern(String s) {
    int length = s.length();
    for (int i = length / 2; i >= 1; i--) {
      if (length % i == 0) {
        if (s.charAt(i - 1) != s.charAt(length - 1)) {
          continue;
        }

        int expectedNumberOfRepeat = length / i;
        int numberOfRepeat = 1;
        String key = s.substring(0, i);

        while (numberOfRepeat < expectedNumberOfRepeat) {
          if (!key.equals(s.substring(numberOfRepeat * i, i + (numberOfRepeat * i)))) {
            break;
          }
          numberOfRepeat++;
        }

        if (expectedNumberOfRepeat == numberOfRepeat) {
          return true;
        }
      }
    }
    return false;
  }
}

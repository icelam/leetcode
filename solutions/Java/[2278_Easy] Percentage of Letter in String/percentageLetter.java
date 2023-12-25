class Solution {
  public int percentageLetter(String s, char letter) {
    int n = s.length();
    int count = 0;

    for (char c: s.toCharArray()) {
      if (c == letter) {
        count++;
      }
    }

    double result = (double) count / n * 100;
    return (int) result;
  }
}

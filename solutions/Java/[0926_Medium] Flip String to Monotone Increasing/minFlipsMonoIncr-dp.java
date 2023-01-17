class Solution {
  public int minFlipsMonoIncr(String s) {
    char[] characters = s.toCharArray();

    int min = 0;
    int numberOfFlips = 0;

    for (char c: characters) {
      if (c == '0') {
        min = Math.min(numberOfFlips, min + 1);
      } else {
        numberOfFlips++;
      }
    }

    return min;
  }
}

class Solution {
  public int countPoints(String rings) {
    boolean[][] colorOnRods = new boolean[10][3];
    int n = rings.length();
    char[] characters = rings.toCharArray();

    for (int i = 0; i < n; i += 2) {
      int rodIndex = characters[i + 1] - '0';

      if (characters[i] == 'R') {
        colorOnRods[rodIndex][0] = true;
      } else if (characters[i] == 'G') {
        colorOnRods[rodIndex][1] = true;
      } else if (characters[i] == 'B') {
        colorOnRods[rodIndex][2] = true;
      }
    }

    int count = 0;

    for (boolean[] rod: colorOnRods) {
      if (rod[0] && rod[1] && rod[2]) {
        count++;
      }
    }

    return count;
  }
}

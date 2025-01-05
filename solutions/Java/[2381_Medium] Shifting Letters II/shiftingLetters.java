class Solution {
  public String shiftingLetters(String s, int[][] shifts) {
    int n = s.length();
    int[] totalShifts = new int[n];

    for (int[] operation: shifts) {
      int start = operation[0];
      int end = operation[1];
      int offset = operation[2] == 0 ? -1 : 1;

      for (int i = start; i <= end; i++) {
        totalShifts[i] += offset;
      }
    }

    char[] characters = s.toCharArray();

    for (int i = 0; i < n; i++) {
      int newChar = (characters[i] - 'a' + totalShifts[i]) % 26;
      if (newChar < 0) {
        newChar += 26;
      }
      characters[i] = (char) (newChar + 'a');
    }

    return new String(characters);
  }
}

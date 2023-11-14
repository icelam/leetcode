class Solution {
  public int countPalindromicSubsequence(String s) {
    char[] characters = s.toCharArray();
    int n = characters.length;
    int[][] occurances = new int[26][2];
    int result = 0;

    for (int[] row: occurances) {
      Arrays.fill(row, -1);
    }

    for (int i = 0; i < n; i++) {
      char c = characters[i];

      if (occurances[c - 'a'][0] == -1) {
        occurances[c - 'a'][0] = i;
      }

      occurances[c - 'a'][1] = i;
    }


    for (int c = 0; c < 26; c++) {
      if (occurances[c][0] == -1) {
        continue;
      }

      boolean[] seen = new boolean[26];

      for (int i = occurances[c][0] + 1; i < occurances[c][1]; i++) {
        if (!seen[characters[i] - 'a']) {
          seen[characters[i] - 'a'] = true;
          result++;
        }
      }
    }

    return result;
  }
}

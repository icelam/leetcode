class Solution {
  public int maxProduct(String[] words) {
    Arrays.sort(words, (a, b) -> b.length() - a.length());
    int result = 0;

    boolean[][] map = new boolean[words.length][26];
    int[] lengths = new int[words.length];

    for (int i = 0; i < words.length; i++) {
      char[] charsFromString = words[i].toCharArray();

      for (char c: charsFromString) {
        map[i][c - 'a'] = true;
      }

      lengths[i] = charsFromString.length;
    }

    for (int k = 0; k < map.length - 1 && lengths[k] * lengths[k + 1] > result; k++) {
      for (int l = k + 1; l < map.length; l++) {
        boolean hasNoOverlap = true;

        for (int m = 0; m < 26 && hasNoOverlap; m++) {
          hasNoOverlap &= !map[k][m] || !map[l][m];
        }

        if (hasNoOverlap) {
          result = Math.max(result, lengths[k] * lengths[l]);
          break;
        }
      }
    }

    return result;
  }
}

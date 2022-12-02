class Solution {
  public boolean closeStrings(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();

    if (m != n) {
      return false;
    }

    int[] word1Count = new int[26];
    int[] word2Count = new int[26];

    for (int i = 0; i < m; i++) {
      char c = word1.charAt(i);
      word1Count[c - 'a']++;
    }

    for (int j = 0; j < n; j++) {
      char c = word2.charAt(j);
      word2Count[c - 'a']++;
    }

    for (int k = 0; k < 26; k++) {
      if (word1Count[k] == word2Count[k]) {
        continue;
      }

      if (word1Count[k] == 0 || word2Count[k] == 0) {
        return false;
      }
    }

    Arrays.sort(word1Count);
    Arrays.sort(word2Count);

    for (int l = 0; l < 26; l++) {
      if (word1Count[l] != word2Count[l]) {
        return false;
      }
    }

    return true;
  }
}

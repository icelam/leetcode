class Solution {
  private boolean isVowel(char c) {
    return (
      c == 'a'
      || c == 'e'
      || c == 'i'
      || c == 'o'
      || c == 'u'
    );
  }

  public int[] vowelStrings(String[] words, int[][] queries) {
    int m = queries.length;
    int n = words.length;
    int[] vowelWordsCount = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      String w = words[i - 1];
      vowelWordsCount[i] = vowelWordsCount[i - 1];

      if (isVowel(w.charAt(0)) && isVowel(w.charAt(w.length() - 1))) {
        vowelWordsCount[i]++;
      }
    }

    int[] result = new int[m];

    for (int i = 0; i < m; i++) {
      result[i] = vowelWordsCount[queries[i][1] + 1] - vowelWordsCount[queries[i][0]];
    }

    return result;
  }
}

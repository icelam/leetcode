class Solution {
  public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
    int word1Length = word1.length;
    int word2Length = word2.length;

    int i = 0;
    int j = 0;
    int k = 0;
    int l = 0;

    while (i < word1Length && j < word2Length) {
      if (word1[i].charAt(k) != word2[j].charAt(l)) {
        return false;
      }

      if (k == word1[i].length() - 1) {
        i++;
        k = 0;
      } else {
        k++;
      }

      if (l == word2[j].length() - 1) {
        j++;
        l = 0;
      } else {
        l++;
      }
    }

    return word1Length == i && k == 0 && j == word2Length && l == 0;
  }
}

class Solution {
  public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
    StringBuilder w1 = new StringBuilder();
    StringBuilder w2 = new StringBuilder();

    int length = Math.max(word1.length, word2.length);

    for (int i = 0; i < length; i++) {
      if (i < word1.length) {
        w1.append(word1[i]);
      }

      if (i < word2.length) {
        w2.append(word2[i]);
      }
    }

    return w1.compareTo(w2) == 0;
  }
}

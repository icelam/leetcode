class Solution {
  public char repeatedCharacter(String s) {
    char[] characters = s.toCharArray();
    boolean[] isSeen = new boolean[26];

    for (char c: characters) {
      if (isSeen[c - 'a']) {
        return c;
      }

      isSeen[c - 'a'] = true;
    }

    // Since constraints stated `s` has at least one repeated letter,
    // This is a fallback return that never happens.
    // This is just for bypassing compilatoin error.
    return ' ';
  }
}

class Solution {
  public int canBeTypedWords(String text, String brokenLetters) {
    boolean[] isBrokenLetter = new boolean[26];

    for (char c: brokenLetters.toCharArray()) {
      isBrokenLetter[c - 'a'] = true;
    }

    int result = 0;

    for (String word: text.split(" ")) {
      boolean canType = true;

      for (char c: word.toCharArray()) {
        if (isBrokenLetter[c - 'a']) {
          canType = false;
          break;
        }
      }

      if (canType) {
        result++;
      }
    }

    return result;
  }
}

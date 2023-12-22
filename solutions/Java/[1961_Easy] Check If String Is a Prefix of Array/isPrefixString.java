class Solution {
  public boolean isPrefixString(String s, String[] words) {
    char[] prefixChars = s.toCharArray();
    int prefixLength = prefixChars.length;
    int prefixIndex = 0;

    for (int i = 0; i < words.length && prefixIndex < prefixLength; i++) {
      String currentWord = words[i];
      int wordLength = currentWord.length();

      if (prefixLength - prefixIndex < wordLength) {
        return false;
      }

      for (char c: currentWord.toCharArray()) {
        if (prefixChars[prefixIndex] != c) {
          return false;
        }

        prefixIndex++;
      }
    }

    return prefixIndex == prefixLength;
  }
}

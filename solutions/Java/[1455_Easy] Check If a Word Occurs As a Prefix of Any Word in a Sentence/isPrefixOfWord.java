class Solution {
  private boolean isWordWithPrefix(String word, String prefix) {
    char[] wordCharacters = word.toCharArray();
    char[] prefixCharacters = prefix.toCharArray();

    if (wordCharacters.length < prefixCharacters.length) {
      return false;
    }

    for (int i = 0; i < prefixCharacters.length; i++) {
      if (wordCharacters[i] != prefixCharacters[i]) {
        return false;
      }
    }

    return true;
  }

  public int isPrefixOfWord(String sentence, String searchWord) {
    String[] words = sentence.split(" ");

    for (int i = 0; i < words.length; i++) {
      if (isWordWithPrefix(words[i], searchWord)) {
        return i + 1;
      }
    }

    return -1;
  }
}

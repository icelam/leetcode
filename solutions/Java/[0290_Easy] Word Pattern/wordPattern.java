class Solution {
  public boolean wordPattern(String pattern, String s) {
    String[] patternMap = new String[26];
    HashSet<String> mappedWords = new HashSet<>();

    String[] words = s.split(" ");
    char[] characters = pattern.toCharArray();

    int wordsLength = words.length;
    int charactersLength = characters.length;

    if (wordsLength != charactersLength) {
      return false;
    }

    for (int i = 0; i < wordsLength; i++) {
      boolean hasMapped = patternMap[characters[i] - 'a'] != null;

      if (
        (!hasMapped && mappedWords.contains(words[i]))
        || (hasMapped && !patternMap[characters[i] - 'a'].equals(words[i]))
      ) {
        return false;
      }

      if (!hasMapped) {
        patternMap[characters[i] - 'a'] = words[i];
        mappedWords.add(words[i]);
      }
    }

    return true;
  }
}

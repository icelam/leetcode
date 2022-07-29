class Solution {
  public boolean isPatternMatch(char[] word, char[] pattern, int length) {
    Map<Character, Character> map1 = new HashMap<>();
    Map<Character, Character> map2 = new HashMap<>();

    for (int i = 0; i < length; ++i) {
      char c1 = word[i];
      char c2 = pattern[i];

      if (!map1.containsKey(c1)) {
        map1.put(c1, c2);
      }

      if (!map2.containsKey(c2)) {
        map2.put(c2, c1);
      }

      if (map1.get(c1) != c2 || map2.get(c2) != c1) {
        return false;
      }
    }

    return true;
  }

  public List<String> findAndReplacePattern(String[] words, String pattern) {
    List<String> result = new ArrayList<>();
    int wordLength = pattern.length();
    char[] patternCharacters = pattern.toCharArray();

    for (String w: words) {
      char[] wordCharacters = w.toCharArray();

      if (isPatternMatch(wordCharacters, patternCharacters, wordLength)) {
        result.add(w);
      }
    }

    return result;
  }
}

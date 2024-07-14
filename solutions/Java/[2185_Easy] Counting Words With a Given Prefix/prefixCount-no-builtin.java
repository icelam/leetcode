class Solution {
  public int prefixCount(String[] words, String pref) {
    char[] prefixCharacters = pref.toCharArray();
    int count = words.length;

    for (String s: words) {
      char[] characters = s.toCharArray();

      if (characters.length < prefixCharacters.length) {
        count--;
        continue;
      }


      for (int i = 0; i < prefixCharacters.length; i++) {
        if (characters[i] != prefixCharacters[i]) {
          count--;
          break;
        }
      }
    }

    return count;
  }
}

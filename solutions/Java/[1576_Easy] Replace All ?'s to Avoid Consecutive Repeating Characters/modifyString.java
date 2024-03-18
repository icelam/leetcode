class Solution {
  public String modifyString(String s) {
    char[] characters = s.toCharArray();
    int n = characters.length;

    for (int i = 0; i < n; i++) {
      char c = characters[i];

      if (c != '?') {
        continue;
      }

      char previousChar = i > 0 ? characters[i - 1] : '?';
      char nextChar = i < n - 1 ? characters[i + 1] : '?';
      char currentChar = 'a';

      while (currentChar == previousChar || currentChar == nextChar) {
        currentChar++;
      }

      characters[i] = currentChar;
    }

    return new String(characters);
  }
}

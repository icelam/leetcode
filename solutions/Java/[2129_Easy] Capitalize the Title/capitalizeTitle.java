class Solution {
  public boolean isCapitalLetter(char c) {
    return Character.isUpperCase(c);
  }

  public char toLowerCase(char c) {
    return (char) (c + 32);
  }

  public char toUpperCase(char c) {
    return (char) (c - 32);
  }

  public String capitalizeTitle(String title) {
    char[] characters = title.toCharArray();
    int n = characters.length;
    int start = 0;
    int end = 0;

    while (start < n) {
      while (end < n && characters[end] != ' ') {
        end++;
      }

      boolean needsCapitalize = ((end - 1) - start) + 1 > 2;

      if (needsCapitalize && !isCapitalLetter(characters[start])) {
        characters[start] = toUpperCase(characters[start]);
      } else if (!needsCapitalize && isCapitalLetter(characters[start])) {
        characters[start] = toLowerCase(characters[start]);
      }

      for (int i = start + 1; i < end; i++) {
        if (isCapitalLetter(characters[i])) {
          characters[i] = toLowerCase(characters[i]);
        }
      }

      start = end + 1;
      end = end + 1;
    }

    return new String(characters);
  }
}

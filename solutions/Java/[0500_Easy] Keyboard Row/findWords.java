class Solution {
  private static int[] rowMap = new int[]{2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3};

  public boolean isCapitalLetter(char c) {
    return Character.isUpperCase(c);
  }

  public char toLowerCase(char c) {
    return (char) (c + 32);
  }

  public int getRow(char c) {
    if (isCapitalLetter(c)) {
      return rowMap[toLowerCase(c) - 'a'];
    }

    return rowMap[c - 'a'];
  }

  public String[] findWords(String[] words) {
    List<String> result = new ArrayList<>();

    for (String w: words) {
      char[] characters = w.toCharArray();
      int row = getRow(characters[0]);
      boolean isSameRow = true;

      for (char c: characters) {
        if (getRow(c) != row) {
          isSameRow = false;
          break;
        }
      }

      if (isSameRow) {
        result.add(w);
      }
    }

    return result.toArray(new String[result.size()]);
  }
}

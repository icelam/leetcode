class Solution {
  public String addSpaces(String s, int[] spaces) {
    int n = s.length();
    char[] characters = s.toCharArray();
    char[] result = new char[n + spaces.length];
    int spaceInserted = 0;
    int i = 0;

    while (spaceInserted < spaces.length) {
      while (i < n && i < spaces[spaceInserted]) {
        result[i + spaceInserted] = characters[i];
        i++;
      }
      result[i + spaceInserted] = ' ';
      spaceInserted++;
    }

    while (i < n) {
      result[i + spaceInserted] = characters[i];
      i++;
    }

    return new String(result);
  }
}

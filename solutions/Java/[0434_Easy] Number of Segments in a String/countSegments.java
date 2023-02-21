class Solution {
  public int countSegments(String s) {
    char[] characters = s.toCharArray();
    int segment = 0;

    for (int i = 0; i < characters.length; i++) {
      if ((i == 0 || characters[i - 1] == ' ') && characters[i] != ' ') {
        segment++;
      }
    }

    return segment;
  }
}

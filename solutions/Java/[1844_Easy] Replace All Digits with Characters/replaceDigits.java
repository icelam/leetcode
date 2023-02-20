class Solution {
  public String replaceDigits(String s) {
    char[] characters = s.toCharArray();
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < characters.length; i++) {
      if ((i & 1) == 1) {
        result.append((char) (characters[i - 1] + (characters[i] - '0')));
      } else {
        result.append(characters[i]);
      }
    }

    return result.toString();
  }
}

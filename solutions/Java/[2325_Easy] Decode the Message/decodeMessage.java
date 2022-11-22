class Solution {
  public String decodeMessage(String key, String message) {
    char[] map = new char[26];

    char nextCharToMap = 'a';

    for (int i = 0; i < key.length(); i++) {
      char c = key.charAt(i);

      if (c != ' ' && ((int) map[c - 'a']) == 0) {
        map[c - 'a'] = nextCharToMap;
        nextCharToMap = (char) (nextCharToMap + 1);
      }
    }

    StringBuilder result = new StringBuilder();

    for (int j = 0; j < message.length(); j++) {
      char c = message.charAt(j);

      if (c == ' ') {
        result.append(' ');
      } else {
        result.append(map[c - 'a']);
      }
    }

    return result.toString();
  }
}

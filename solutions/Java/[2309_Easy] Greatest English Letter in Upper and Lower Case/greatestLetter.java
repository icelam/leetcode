class Solution {
  public String greatestLetter(String s) {
    boolean[] isUpperCaseSeen = new boolean[26];
    boolean[] isLowerCaseSeen = new boolean[26];

    for (char c: s.toCharArray()) {
      if (Character.isUpperCase(c)) {
        isUpperCaseSeen[c - 'A'] = true;
      } else {
        isLowerCaseSeen[c - 'a'] = true;
      }
    }

    for (int i = 25; i >= 0; i--) {
      if (isUpperCaseSeen[i] && isLowerCaseSeen[i]) {
        return Character.toString((char) ('A' + i));
      }
    }

    return "";
  }
}

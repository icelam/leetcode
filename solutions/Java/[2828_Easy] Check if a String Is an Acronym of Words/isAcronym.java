class Solution {
  public boolean isAcronym(List<String> words, String s) {
    if (words.size() != s.length()) {
      return false;
    }

    char[] characters = s.toCharArray();

    for (int i = 0; i < s.length(); i++) {
      if (words.get(i).charAt(0) != characters[i]) {
        return false;
      }
    }

    return true;
  }
}

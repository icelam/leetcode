class Solution {
  public boolean isPrefix(String s, String prefix) {
    char[] prefixChar = prefix.toCharArray();
    char[] sChar = s.toCharArray();

    if (prefixChar.length > sChar.length) {
      return false;
    }

    for (int i = 0; i < prefixChar.length; i++) {
      if (prefixChar[i] != sChar[i]) {
        return false;
      }
    }

    return true;
  }

  public int countPrefixes(String[] words, String s) {
    int result = 0;

    for (String w: words) {
      if (isPrefix(s, w)) {
        result++;
      }
    }

    return result;
  }
}

class Solution {
  private boolean isPrefix(String s, String prefix) {
    int i = 0;
    int j = 0;

    char[] characters = s.toCharArray();
    char[] prefixChars = prefix.toCharArray();

    while (i < s.length() && j < prefix.length()) {
      if (characters[i] != prefixChars[j]) {
        return false;
      }

      i++;
      j++;
    }

    return j == prefix.length();
  }

  private boolean isSuffix(String s, String suffix) {
    int i = s.length() - 1;
    int j = suffix.length() - 1;

    char[] characters = s.toCharArray();
    char[] suffixChars = suffix.toCharArray();

    while (i >= 0 && j >= 0) {
      if (characters[i] != suffixChars[j]) {
        return false;
      }

      i--;
      j--;
    }

    return j == -1;
  }

  public int countPrefixSuffixPairs(String[] words) {
    int result = 0;

    for (int i = 0; i < words.length; i++) {
      for (int j = i + 1; j < words.length; j++) {
        if (isPrefix(words[j], words[i]) && isSuffix(words[j], words[i])) {
          result++;
        }
      }
    }

    return result;
  }
}

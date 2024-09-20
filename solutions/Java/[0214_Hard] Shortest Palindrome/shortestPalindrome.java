class Solution {
  public String shortestPalindrome(String s) {
    int n = s.length();

    char[] characters = s.toCharArray();
    char[] reversedCharacters = new char[n];

    for (int i = 0; i < n; i++) {
      reversedCharacters[i] = characters[n - i - 1];
    }

    for (int i = 0; i < n; i++) {
      boolean isPrefixSuffixMatch = true;

      for (int j = i; j < n; j++) {
        if (characters[j - i] != reversedCharacters[j]) {
          isPrefixSuffixMatch = false;
          break;
        }
      }

      if (isPrefixSuffixMatch) {
        StringBuilder result = new StringBuilder();
        result.append(reversedCharacters, 0, i);
        result.append(s);
        return result.toString();
      }
    }

    return "";
  }
}

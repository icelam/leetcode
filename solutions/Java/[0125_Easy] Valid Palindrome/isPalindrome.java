class Solution {
  public boolean isAlphaNumeric(char c) {
    return Character.isLetterOrDigit(c);
  }

  public char toLowerCase(char c) {
    return Character.isUpperCase(c) ? (char) (c + ('a' - 'A')) : c;
  }

  public boolean isPalindrome(String s) {
    char[] characters = s.toCharArray();

    int n = characters.length;
    int start = 0;
    int end = n - 1;

    while (start < end) {
      while (start < n && !isAlphaNumeric(characters[start])) {
        start++;
      }

      while (end > 0 && !isAlphaNumeric(characters[end])) {
        end--;
      }

      if (start >= end) {
        break;
      }

      char left = toLowerCase(characters[start]);
      char right = toLowerCase(characters[end]);

      if (left != right) {
        return false;
      }

      start++;
      end--;
    }

    return true;
  }
}

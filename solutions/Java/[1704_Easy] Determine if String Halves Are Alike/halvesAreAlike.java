class Solution {
  private boolean isVowels(char c) {
    return (
      c == 'a'
      || c == 'e'
      || c == 'i'
      || c == 'o'
      || c == 'u'
      || c == 'A'
      || c == 'E'
      || c == 'I'
      || c == 'O'
      || c == 'U'
    );
  }

  public boolean halvesAreAlike(String s) {
    int n = s.length() / 2;

    int vowelsOnLeft = 0;
    int vowelsOnRight = 0;

    for (int i = 0; i < n; i++) {
      if (isVowels(s.charAt(i))) {
        vowelsOnLeft++;
      }

      if (isVowels(s.charAt(i + n))) {
        vowelsOnRight++;
      }
    }

    return vowelsOnLeft == vowelsOnRight;
  }
}

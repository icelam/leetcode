class Solution {
  private boolean isVowel(char c) {
    return (
      c == 'a'
      || c == 'e'
      || c == 'i'
      || c == 'o'
      || c == 'u'
    );
  }

  public int vowelStrings(String[] words, int left, int right) {
    int count = 0;

    for (int i = left; i <= right; i++) {
      String currentWord = words[i];

      if (isVowel(currentWord.charAt(0)) && isVowel(currentWord.charAt(currentWord.length() - 1))) {
        count++;
      }
    }

    return count;
  }
}

class Solution {
  public boolean isCapitalLetter(char c) {
    return Character.isUpperCase(c);
  }

  public boolean detectCapitalUse(String word) {
    int numberOfCapitalLetter = 0;
    int wordLength = word.length();

    for (int i = 0; i < wordLength; i++) {
      if (isCapitalLetter(word.charAt(i))) {
        numberOfCapitalLetter++;
      }
    }

    return (
      (isCapitalLetter(word.charAt(0)) && numberOfCapitalLetter == 1)
      || numberOfCapitalLetter == wordLength
      || numberOfCapitalLetter == 0
    );
  }
}

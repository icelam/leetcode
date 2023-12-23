class Solution {
  private char[] allVowels = new char[]{'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};

  private boolean isVowel(Character c) {
    for (char vowel: allVowels) {
      if (c == vowel) {
        return true;
      }
    }

    return false;
  }

  public String toGoatLatin(String sentence) {
    StringBuilder builder = new StringBuilder();
    String[] words = sentence.split(" ");
    int n = words.length;

    for (int i = 0; i < n; i++) {
      if (i != 0) {
        builder.append(' ');
      }

      char[] currentChars = words[i].toCharArray();
      int startIndex = isVowel(currentChars[0]) ? 0 : 1;

      for (int j = startIndex; j < currentChars.length; j++) {
        builder.append(currentChars[j]);
      }

      for (int j = 0; j < startIndex; j++) {
        builder.append(currentChars[j]);
      }

      builder.append("ma");

      for (int j = 0; j < i + 1; j++) {
        builder.append('a');
      }
    }

    return builder.toString();
  }
}

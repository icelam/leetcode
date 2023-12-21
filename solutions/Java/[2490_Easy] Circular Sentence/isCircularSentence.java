class Solution {
  public boolean isCircularSentence(String sentence) {
    char previousEnd = sentence.charAt(sentence.length() - 1);

    for (String word: sentence.split(" ")) {
      if (word.charAt(0) != previousEnd) {
        return false;
      }

      previousEnd = word.charAt(word.length() - 1);
    }

    return true;
  }
}

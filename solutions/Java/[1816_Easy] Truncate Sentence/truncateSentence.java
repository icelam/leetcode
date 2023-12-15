class Solution {
  public String truncateSentence(String s, int k) {
    char[] characters = s.toCharArray();
    int wordCount = 0;
    StringBuilder builder = new StringBuilder();

    for (char c: characters) {
      if (c == ' ') {
        wordCount++;
      }

      if (wordCount == k) {
        break;
      }

      builder.append(c);
    }

    return builder.toString();
  }
}

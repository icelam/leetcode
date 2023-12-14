class Solution {
  public String sortSentence(String s) {
    String[] words = new String[9];
    char[] characters = s.toCharArray();
    StringBuilder builder = new StringBuilder();
    int count = 0;

    for (char c: characters) {
      if (Character.isDigit(c)) {
        words[(c - '0') - 1] = builder.toString();
        builder.delete(0, builder.length());
        count++;
      } else if (c != ' ') {
        builder.append(c);
      }
    }

    for (int i = 0; i < count; i++) {
      if (i != 0) {
        builder.append(' ');
      }

      builder.append(words[i]);
    }

    return builder.toString();
  }
}

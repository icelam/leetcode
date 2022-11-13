class Solution {
  public String reverseWords(String s) {
    StringBuilder result = new StringBuilder();
    StringBuilder word = new StringBuilder();
    char previousChar = ' ';
    boolean isFirstWord = true;

    int start = 0;
    int end = s.length() - 1;

    while (s.charAt(start) == ' ') {
      start++;
    }

    while (s.charAt(end) == ' ') {
      end--;
    }

    for (int i = start; i <= end; i++) {
      char currentChar = s.charAt(i);

      if (currentChar != ' ') {
        word.append(currentChar);
      }

      if ((currentChar == ' ' && previousChar != ' ') || i == end) {
        if (!isFirstWord) {
          result.insert(0, ' ');
        }

        isFirstWord = false;
        result.insert(0, word);
        word.setLength(0);
      }

      previousChar = currentChar;
    }

    return result.toString();
  }
}

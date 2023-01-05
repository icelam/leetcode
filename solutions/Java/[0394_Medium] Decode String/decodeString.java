class Solution {
  public boolean isDigit(char c) {
    return Character.isDigit(c);
  }

  public boolean isStartOfRepeatMark(char c) {
    return c == '[';
  }

  public boolean isEndOfRepeatMark(char c) {
    return c == ']';
  }

  public boolean isLetter(char c) {
    return !isDigit(c) && !isStartOfRepeatMark(c) && !isEndOfRepeatMark(c);
  }

  public String decodeString(String s) {
    char[] characters = s.toCharArray();
    Stack<String> parts = new Stack<>();
    Stack<Integer> frequencies = new Stack<>();
    int n = characters.length;
    int i = 0;

    while (i < n) {
      if (isDigit(characters[i])) {
        int occurance = 0;

        while (i < n && isDigit(characters[i])) {
          occurance = occurance * 10 + characters[i] - '0';
          i++;
        }

        frequencies.push(occurance);
      } else if (isStartOfRepeatMark(characters[i])) {
        if (!isLetter(characters[i + 1])) {
          parts.push("");
        }

        i++;
      } else if (isEndOfRepeatMark(characters[i])) {
        StringBuilder repeatedPart = new StringBuilder();
        String currentPart = parts.pop();

        for (int occurance = frequencies.pop(); occurance > 0; occurance--) {
          repeatedPart.append(currentPart);
        }

        if (!parts.isEmpty()) {
          String previousPart = parts.pop();
          repeatedPart.insert(0, previousPart);
        }

        parts.push(repeatedPart.toString());
        i++;
      } else {
        StringBuilder currentPart = new StringBuilder();
        char previousChar = i > 0 ? characters[i - 1] : ' ';

        while (i < n && isLetter(characters[i])) {
          currentPart.append(characters[i]);
          i++;
        }

        if (isEndOfRepeatMark(previousChar)) {
          String previousPart = parts.pop();
          currentPart.insert(0, previousPart);
        }

        parts.push(currentPart.toString());
      }
    }

    return parts.pop();
  }
}

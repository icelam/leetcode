class Solution {
  public List<String> fullJustify(String[] words, int maxWidth) {
    int previousStart = 0;
    int i = 0;
    int n = words.length;
    List<String> result = new ArrayList<>();

    while (i < n) {
      previousStart = i;
      int charCount = 0;
      int wordCount = 0;

      while (i < n && charCount + wordCount + words[i].length() <= maxWidth) {
        charCount += words[i].length();
        wordCount++;
        i++;
      }

      StringBuilder builder = new StringBuilder();
      boolean isLastLine = i >= n;
      int spaceNeededCount = Math.max(wordCount - 1, 1);
      int minSpaceLength = (maxWidth - charCount) / spaceNeededCount;
      int spaceRemaining = (maxWidth - charCount) % spaceNeededCount;

      if (isLastLine) {
        minSpaceLength = 1;
        spaceRemaining = 0;
      }

      for (int j = previousStart; j < i; j++) {
        if (j - previousStart > 0) {
          int currentSpaceLength = minSpaceLength;

          if (spaceRemaining > 0) {
            currentSpaceLength++;
            spaceRemaining--;
          }

          for (int k = 0; k < currentSpaceLength; k++) {
            builder.append(' ');
          }
        }

        builder.append(words[j]);
      }

      if (builder.length() < maxWidth) {
        int lastLineSpaceCount = maxWidth - builder.length();

        for (int k = 0; k < lastLineSpaceCount; k++) {
          builder.append(' ');
        }
      }

      result.add(builder.toString());
    }

    return result;
  }
}

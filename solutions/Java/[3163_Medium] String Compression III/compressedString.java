class Solution {
  public String compressedString(String word) {
    int start = 0;
    char[] characters = word.toCharArray();
    int length = characters.length;
    StringBuilder builder = new StringBuilder();

    while (start < length) {
      int count = 1;
      char currentChar = characters[start];

      while (start + count < length && characters[start + count] == currentChar) {
        count++;
      }

      start += count;

      while (count > 0) {
        int appendCount = Math.min(count, 9);
        builder.append(appendCount);
        builder.append(currentChar);
        count -= appendCount;
      }
    }

    return builder.toString();
  }
}

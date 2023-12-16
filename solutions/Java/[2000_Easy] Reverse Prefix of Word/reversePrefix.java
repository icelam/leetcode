class Solution {
  public String reversePrefix(String word, char ch) {
    char[] characters = word.toCharArray();
    int n = characters.length;
    int firstOccuranceIndex = -1;

    for (int i = 0; i < n; i++) {
      if (characters[i] == ch) {
        firstOccuranceIndex = i;
        break;
      }
    }

    if (firstOccuranceIndex == -1) {
      return word;
    }

    StringBuilder builder = new StringBuilder();

    for (int i = firstOccuranceIndex; i >= 0; i--) {
      builder.append(characters[i]);
    }

    for (int i = firstOccuranceIndex + 1; i < n; i++) {
      builder.append(characters[i]);
    }

    return builder.toString();
  }
}

class Solution {
  public boolean isLetter(char c) {
    return Character.isLetter(c);
  }

  public boolean isLowerCase(char c) {
    return c >= 'a' && c <= 'z';
  }

  public char toLowerCase(char c) {
    return (char) (c - 'A' + 'a');
  }

  public String mostCommonWord(String paragraph, String[] banned) {
    char[] characters = paragraph.toCharArray();
    int n = characters.length;
    int i = 0;
    HashMap<String, Integer> frequencies = new HashMap<>();

    while (i < n) {
      if (!isLetter(characters[i])) {
        i++;
        continue;
      }

      StringBuilder wordBuilder = new StringBuilder();

      while (i < n && isLetter(characters[i])) {
        char c = characters[i];
        wordBuilder.append(isLowerCase(c) ? c : toLowerCase(c));
        i++;
      }

      String word = wordBuilder.toString();

      frequencies.put(word, frequencies.getOrDefault(word, 0) + 1);
    }

    int currentMax = 0;
    String result = "";

    for (String bannedWord: banned) {
      if (frequencies.containsKey(bannedWord)) {
        frequencies.remove(bannedWord);
      }
    }

    for (String word: frequencies.keySet()) {
      int frequency = frequencies.get(word);

      if (frequency > currentMax) {
        result = word;
        currentMax = frequency;
      }
    }

    return result;
  }
}

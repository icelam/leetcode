class Solution {
  public String[] uncommonFromSentences(String s1, String s2) {
    HashSet<String> uniqueWords = new HashSet<>();
    HashSet<String> duplicateWords = new HashSet<>();

    for (String word: s1.split(" ")) {
      if (uniqueWords.contains(word)) {
        uniqueWords.remove(word);
        duplicateWords.add(word);
      } else if (!duplicateWords.contains(word)) {
        uniqueWords.add(word);
      }
    }

    for (String word: s2.split(" ")) {
      if (uniqueWords.contains(word)) {
        uniqueWords.remove(word);
        duplicateWords.add(word);
      } else if (!duplicateWords.contains(word)) {
        uniqueWords.add(word);
      }
    }

    int size = uniqueWords.size();
    String[] result = new String[size];
    int i = 0;

    for (String word: uniqueWords) {
      result[i] = word;
      i++;
    }

    return result;
  }
}

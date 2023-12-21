class Solution {
  public String[] uncommonFromSentences(String s1, String s2) {
    HashMap<String, Integer> frequency = new HashMap<>();

    for (String word: s1.split(" ")) {
      frequency.put(word, frequency.getOrDefault(word, 0) + 1);
    }

    for (String word: s2.split(" ")) {
      frequency.put(word, frequency.getOrDefault(word, 0) + 1);
    }

    List<String> uncommonWords = new ArrayList<>();

    for (String word: frequency.keySet()) {
      if (frequency.get(word) == 1) {
        uncommonWords.add(word);
      }
    }

    int size = uncommonWords.size();
    String[] result = new String[size];

    for (int i = 0; i < size; i++) {
      result[i] = uncommonWords.get(i);
    }

    return result;
  }
}

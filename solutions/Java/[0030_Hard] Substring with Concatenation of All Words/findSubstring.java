class Solution {
  public List<Integer> findSubstring(String s, String[] words) {
    int stringLength = s.length();
    int wordLength = words[0].length();
    int numberOfWords = words.length;
    int substringLength = wordLength * numberOfWords;

    List<Integer> result =  new ArrayList<>();
    HashMap<String, Integer> wordCount = new HashMap<>();

    if (s.length() < wordLength * numberOfWords) {
      return result;
    }

    for (String w : words) {
      wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
    }

    for (int i = 0; i < stringLength - substringLength + 1; i++) {
      int numberOfWordsMatched = 0;
      HashMap<String, Integer> remainingWordCount = new HashMap<>(wordCount);

      for (int j = i; j < i + substringLength; j += wordLength) {
        String part = s.substring(j, j + wordLength);

        int currentRemainingWordCount = remainingWordCount.getOrDefault(part, 0);
        if (currentRemainingWordCount == 0) {
          break;
        }

        remainingWordCount.put(part, currentRemainingWordCount - 1);
        numberOfWordsMatched++;
      }

      if (numberOfWordsMatched == numberOfWords) {
        result.add(i);
      }
    }

    return result;
  }
}

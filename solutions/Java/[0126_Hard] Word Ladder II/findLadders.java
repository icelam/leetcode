class Solution {
  private boolean isOneCharDifferernt(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }

    char[] s1Chars = s1.toCharArray();
    char[] s2Chars = s2.toCharArray();
    int differenceCount = 0;

    for (int j = 0; j < s1Chars.length; j++) {
      if (s1Chars[j] != s2Chars[j]) {
        differenceCount++;
      }
    }

    return differenceCount == 1;
  }

  private HashMap<String, HashSet<String>> generateAdjencyList(String beginWord, List<String> wordList) {
    HashMap<String, HashSet<String>> adjencyList = new HashMap<>();
    HashSet<String> uniqueWordList = new HashSet<>(wordList);
    uniqueWordList.add(beginWord);

    for (String word: uniqueWordList) {
      HashSet<String> neighbour = new HashSet<>();
      adjencyList.put(word, neighbour);

      for (String candidate: uniqueWordList) {
        if (isOneCharDifferernt(word, candidate)) {
          neighbour.add(candidate);
        }
      }
    }

    return adjencyList;
  }

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> result = new ArrayList<>();

    if (!wordList.contains(endWord)) {
      return result;
    }

    HashMap<String, HashSet<String>> adjencyList = generateAdjencyList(beginWord, wordList);

    HashSet<String> visited = new HashSet<>();
    visited.add(beginWord);

    Queue<List<String>> queue = new LinkedList<>();
    queue.offer(Arrays.asList(beginWord));

    boolean isEndOfSequence = false;

    while (!queue.isEmpty() && !isEndOfSequence) {
      int batchSize = queue.size();
      HashSet<String> currentVisited = new HashSet<>();


      for (int i = 0; i < batchSize; i++) {
        List<String> sequence = queue.poll();
        int sequenceLength = sequence.size();
        String previousWord = sequence.get(sequenceLength - 1);

        if (previousWord.equals(endWord)) {
          result.add(sequence);
          isEndOfSequence = true;
          continue;
        }

        if (result.size() > 0 && sequenceLength >= result.get(0).size()) {
          continue;
        }

        for (String newWord: adjencyList.get(previousWord)) {
          if (previousWord.length() != newWord.length()) {
            continue;
          }

          int differenceCount = 0;

          char[] previousChars = previousWord.toCharArray();
          char[] newChars = newWord.toCharArray();

          for (int j = 0; j < previousChars.length; j++) {
            if (previousChars[j] != newChars[j]) {
              differenceCount++;
            }
          }

          if (differenceCount == 1 && !visited.contains(newWord)) {
            List<String> newSequence = new ArrayList(sequence);
            newSequence.add(newWord);
            queue.add(newSequence);
            currentVisited.add(newWord);
          }
        }
      }

      visited.addAll(currentVisited);
    }

    return result;
  }
}

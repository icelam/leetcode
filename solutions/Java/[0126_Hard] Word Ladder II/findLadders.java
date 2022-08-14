class Solution {
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> result = new ArrayList<>();

    if (!wordList.contains(endWord)) {
      return result;
    }

    HashSet<String> uniqueWordList = new HashSet<>(wordList);

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
        String previousWord = sequence.get(sequence.size() - 1);

        if (previousWord.equals(endWord)) {
          result.add(sequence);
          isEndOfSequence = true;
          continue;
        }

        for (String newWord: uniqueWordList) {
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

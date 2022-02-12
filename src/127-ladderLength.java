import java.util.*;

class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (!wordList.contains(endWord)) {
      return 0;
    }

    HashMap<String, Integer> visited = new HashMap<String, Integer>();
    visited.put(beginWord, 1);

    Queue<String> queue = new LinkedList<>();
    queue.add(beginWord);

    while (queue.size() > 0) {
      String word = queue.remove();

      if (word.equals(endWord)) {
        break;
      }

      for (String newWord: wordList) {
        if (word.length() != newWord.length()) {
          continue;
        }

        int differenceCount = 0;

        for (int i = 0; i < word.length(); i++) {
          if (word.charAt(i) != newWord.charAt(i)) {
            differenceCount++;
          }
        }

        if (differenceCount == 1) {
          if (!visited.containsKey(newWord)) {
            visited.put(newWord, visited.get(word) + 1);
            queue.add(newWord);
          }
        }
      }
    }

    return visited.getOrDefault(endWord, 0);
  }
}


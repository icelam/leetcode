class Solution {
  public int countWords(String[] words1, String[] words2) {
    HashMap<String, Integer> occurance1 = new HashMap<>();
    HashMap<String, Integer> occurance2 = new HashMap<>();

    for (String w: words1) {
      occurance1.put(w, occurance1.getOrDefault(w, 0) + 1);
    }

    for (String w: words2) {
      occurance2.put(w, occurance2.getOrDefault(w, 0) + 1);
    }

    int result = 0;

    for (String w: words1) {
      if (occurance1.getOrDefault(w, 0) == 1 && occurance2.getOrDefault(w, 0) == 1) {
        result++;
      }
    }

    return result;
  }
}

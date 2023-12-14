class Solution {
  public List<Integer> findWordsContaining(String[] words, char x) {
    List<Integer> result = new ArrayList<>();
    int n = words.length;

    for (int i = 0; i < n; i++) {
      char[] characters = words[i].toCharArray();

      for (char c: characters) {
        if (c == x) {
          result.add(i);
          break;
        }
      }
    }

    return result;
  }
}

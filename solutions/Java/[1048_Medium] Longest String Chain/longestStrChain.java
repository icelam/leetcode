class Solution {
  public int longestStrChain(String[] words) {
    HashMap<String, Integer> map = new HashMap<>();
    int maxLength = 0;

    Arrays.sort(words, (a, b) -> a.length() - b.length());

    for (String w: words) {
      int currentLength = w.length();

      for (int i = 0; i < currentLength; i++) {
        String str = w.substring(0, i) + w.substring(i + 1);
        map.put(w, Math.max(map.getOrDefault(w, 0), map.getOrDefault(str, 0) + 1));
      }

      maxLength = Math.max(maxLength, map.get(w));
    }

    return maxLength;
  }
}

class Solution {
  public int maximumNumberOfStringPairs(String[] words) {
    HashSet<String> set = new HashSet<>();
    int count = 0;

    for (String w: words) {
      StringBuilder builder = new StringBuilder();
      builder.append(w.charAt(1));
      builder.append(w.charAt(0));
      String reversedWord = builder.toString();

      if (set.contains(reversedWord)) {
        set.remove(reversedWord);
        count++;
        continue;
      }

      set.add(w);
    }

    return count;
  }
}

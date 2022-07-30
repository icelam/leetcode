class Solution {
  public List<String> wordSubsets(String[] words1, String[] words2) {
    List<String> result = new ArrayList<>();
    int[] requiredChars = new int[26];

    for (String subset: words2) {
      char[] subsetChars = subset.toCharArray();
      int[] currentRequiredChars = new int[26];

      for (char c: subsetChars) {
        currentRequiredChars[c - 'a']++;
      }

      for (int i = 0; i < 26; i++) {
        requiredChars[i] = Math.max(requiredChars[i], currentRequiredChars[i]);
      }
    }

    for (String w: words1) {
      char[] wordChars = w.toCharArray();
      int[] currentCount = new int[26];

      for (char c: wordChars) {
        currentCount[c - 'a']++;
      }

      boolean hasSubset = true;

      for (int j = 0; j < 26; j++) {
        if (currentCount[j] < requiredChars[j]) {
          hasSubset = false;
        }
      }

      if (hasSubset) {
        result.add(w);
      }
    }

    return result;
  }
}

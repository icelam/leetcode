class Solution {
  public List<String> commonChars(String[] words) {
    int[] minFrequency = new int[26];
    Arrays.fill(minFrequency, Integer.MAX_VALUE);

    for (String w: words) {
      int[] frequency = new int[26];

      for (char c: w.toCharArray()) {
        frequency[c - 'a']++;
      }

      for (int i = 0; i < 26; i++) {
        if (frequency[i] < minFrequency[i]) {
          minFrequency[i] = frequency[i];
        }
      }
    }

    List<String> result = new ArrayList<>();

    for (int i = 0; i < 26; i++) {
      for (int j = 0; j < minFrequency[i]; j++) {
        result.add(Character.toString('a' + i));
      }
    }

    return result;
  }
}

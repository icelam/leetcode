class Solution {
  public int minDeletions(String s) {
    int[] frequency = new int[26];
    char[] characters = s.toCharArray();

    for (char c: characters) {
      frequency[c - 'a']++;
    }

    HashSet<Integer> uniqueFrequencies = new HashSet<>();
    int deletedCount = 0;

    for (int i = 0; i < 26; i++) {
      while (frequency[i] > 0 && uniqueFrequencies.contains(frequency[i])) {
        frequency[i]--;
        deletedCount++;
      }

      uniqueFrequencies.add(frequency[i]);
    }

    return deletedCount;
  }
}

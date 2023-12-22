class Solution {
  public boolean areOccurrencesEqual(String s) {
    int firstOccurance = -1;
    int[] frequency = new int[26];

    for (char c: s.toCharArray()) {
      frequency[c - 'a']++;
    }

    for (int i = 0; i < 26; i++) {
      if (frequency[i] == 0) {
        continue;
      }

      if (firstOccurance == -1) {
        firstOccurance = i;
      }

      if (frequency[i] != frequency[firstOccurance]) {
        return false;
      }
    }

    return true;
  }
}

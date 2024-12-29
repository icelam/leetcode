class Solution {
  private boolean hasDistinctCharacters(int[] frequency) {
    for (int count: frequency) {
      if (count > 1) {
        return false;
      }
    }

    return true;
  }

  public int countGoodSubstrings(String s) {
    int n = s.length();

    if (n < 3) {
      return 0;
    }

    char[] characters = s.toCharArray();
    int[] frequency = new int[26];
    int result = 0;

    frequency[characters[0] - 'a']++;
    frequency[characters[1] - 'a']++;

    for (int i = 2; i < n; i++) {
      char c = characters[i];
      frequency[c - 'a']++;

      if (hasDistinctCharacters(frequency)) {
        result++;
      }

      frequency[characters[i - 2] - 'a']--;
    }

    return result;
  }
}

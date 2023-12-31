class Solution {
  public int maxLengthBetweenEqualCharacters(String s) {
    int n = s.length();
    char[] characters = s.toCharArray();
    int result = -1;
    int[] firstSeen = new int[26];
    Arrays.fill(firstSeen, -1);

    for (int i = 0; i < n; i++) {
      if (firstSeen[characters[i] - 'a'] == -1) {
        firstSeen[characters[i] - 'a'] = i;
      }
    }

    for (int i = n - 1; i >= 0; i--) {
      if (firstSeen[characters[i] - 'a'] != -1 && firstSeen[characters[i] - 'a'] < i) {
        result = Math.max(result, i - firstSeen[characters[i] - 'a'] - 1);
      }
    }

    return result;
  }
}

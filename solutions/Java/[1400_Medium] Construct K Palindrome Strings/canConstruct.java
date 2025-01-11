class Solution {
  public boolean canConstruct(String s, int k) {
    int n = s.length();

    if (k > n) {
      return false;
    }

    char[] characters = s.toCharArray();
    int[] frequency = new int[26];

    for (int i = 0; i < n; i++) {
      char c = characters[i];
      frequency[c - 'a']++;
    }

    int oddCount = 0;

    for (int i = 0; i < 26; i++) {
      oddCount += frequency[i] % 2;
    }

    return k >= oddCount;
  }
}

class Solution {
  public boolean makeEqual(String[] words) {
    int n = words.length;
    int[] frequency = new int[26];

    for (String w: words) {
      int m = w.length();

      for (int i = 0; i < m; i++) {
        frequency[w.charAt(i) - 'a']++;
      }
    }

    for (int f: frequency) {
      if (f % n != 0) {
        return false;
      }
    }

    return true;
  }
}

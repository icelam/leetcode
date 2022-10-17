class Solution {
  public boolean checkIfPangram(String sentence) {
    if (sentence.length() < 26) {
      return false;
    }

    char[] characters = sentence.toCharArray();
    int[] counts = new int[26];

    for (char c: characters) {
      counts[c - 'a']++;
    }

    for (int n: counts) {
      if (n < 1) {
        return false;
      }
    }

    return true;
  }
}

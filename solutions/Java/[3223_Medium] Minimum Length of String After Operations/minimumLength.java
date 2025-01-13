class Solution {
  public int minimumLength(String s) {
    int remainingCharacters = s.length();
    int[] frequency = new int[26];

    for (char c: s.toCharArray()) {
      frequency[c - 'a']++;
    }

    int deleteCount = 0;

    for (int count: frequency) {
      if (count == 0) {
        continue;
      }

      if (count % 2 == 1) {
        remainingCharacters -= count - 1;
      } else {
        remainingCharacters -= count - 2;
      }
    }

    return remainingCharacters;
  }
}

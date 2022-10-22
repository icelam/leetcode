class Solution {
  public String minWindow(String s, String t) {
    int sLength = s.length();
    int tLength = t.length();

    if (sLength < tLength) {
      return "";
    }

    char[] tCharacters = t.toCharArray();
    char[] sCharacters = s.toCharArray();

    int mapSize = 'z' - 'A' + 1;
    int[] tCount = new int[mapSize];
    int[] currentCount = new int[mapSize];
    HashSet<Character> requiredCharacters = new HashSet<>();

    for (char c: tCharacters) {
      tCount[c - 'A']++;
      requiredCharacters.add(c);
    }

    int left = 0;
    int right = 0;
    int requiredMatchCount = requiredCharacters.size();
    int matchCount = 0;

    int minStart = -1;
    int minEnd = -1;
    int minLength = sLength;

    while (right < sLength) {
      char rightCharacter = sCharacters[right];

      if (tCount[rightCharacter - 'A'] > 0) {
        currentCount[rightCharacter - 'A']++;

        if (currentCount[rightCharacter - 'A'] == tCount[rightCharacter - 'A']) {
          matchCount++;
        }
      }

      right++;

      while (matchCount == requiredMatchCount) {
        char leftCharacter = sCharacters[left];

        if (
          currentCount[leftCharacter - 'A'] > 0
          && currentCount[leftCharacter - 'A'] >= tCount[leftCharacter - 'A']
        ) {
          if (right - left <= minLength) {
            minStart = left;
            minEnd = right;
            minLength = right - left;
          }

          currentCount[leftCharacter - 'A']--;

          if (currentCount[leftCharacter - 'A'] < tCount[leftCharacter - 'A']) {
            matchCount--;
          }
        }

        left++;
      }
    }

    return minStart == -1 ? "" : s.substring(minStart, minEnd);
  }
}

class Solution {
  public int countCharacters(String[] words, String chars) {
    int result = 0;
    int[] charFrequency = new int[26];

    for (char c: chars.toCharArray()) {
      charFrequency[c - 'a']++;
    }

    for (String word: words) {
      int[] wordFrequency = new int[26];
      boolean isValid = true;

      for (char c: word.toCharArray()) {
        wordFrequency[c - 'a']++;

        if (wordFrequency[c - 'a'] > charFrequency[c - 'a']) {
          isValid = false;
          break;
        }
      }

      if (isValid) {
        result += word.length();
      }
    }

    return result;
  }
}

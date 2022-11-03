class Solution {
  public int longestPalindrome(String[] words) {
    int[][] count = new int[26][26];
    for (String word: words) {
      count[word.charAt(0) - 'a'][word.charAt(1) - 'a']++;
    }

    int maxLength = 0;

    // Count ("ab", "ba")
    for (int i = 0; i < 26; i++) {
      for (int j = i + 1; j < 26; j++)  {
        int currentCount = count[i][j] < count[j][i] ? count[i][j] : count[j][i];
        if (currentCount > 0) {
          maxLength += currentCount << 2;
        }
      }
    }

    // Count all ("aa")
    for (int i = 0; i < 26; i++) {
      int currentCount = (count[i][i] >> 1) << 1;

      if (currentCount > 0) {
        maxLength += currentCount << 1;
      }
    }

    // Pick any remaining odd ("aa") pair
    for (int i = 0; i < 26; i++) {
      if (count[i][i] % 2 == 1) {
        maxLength += 2;
        break;
      }
    }

    return maxLength;
  }
}

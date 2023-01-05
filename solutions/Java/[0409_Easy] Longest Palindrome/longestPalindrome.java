class Solution {
  public int longestPalindrome(String s) {
    int mapSize = 'z' - 'A' + 1;
    int[] frequencies = new int[mapSize];
    int length = s.length();

    for (char c: s.toCharArray()) {
      frequencies[c - 'A']++;
    }

    int result = 0;
    boolean hasOddFrequency = false;

    for (int frequency: frequencies) {
      if (frequency % 2 == 1) {
        hasOddFrequency = true;
        result += frequency - 1;
      } else {
        result += frequency;
      }
    }

    return hasOddFrequency ? result + 1 : result;
  }
}

class Solution {
  public static int MAX_WORD_LENGTH = 100;

  public boolean equalFrequency(String word) {
    int[] count = new int[26];
    char[] characters = word.toCharArray();
    int[] frequency = new int[MAX_WORD_LENGTH + 1];

    for (char c: characters) {
      if (count[c - 'a'] > 0) {
        frequency[count[c - 'a']]--;
      }
      count[c - 'a']++;
      frequency[count[c - 'a']]++;
    }

    // Case "zz": Deleting any of the z will still make frequency unique
    boolean isHavingOneUniqueCharacters = count[characters[0] - 'a'] == characters.length;
    if (isHavingOneUniqueCharacters) {
      return true;
    }

    boolean hasAdjacentFrequency = false;
    int uniqueFrequencyCount = 0;

    for (int i = 0; i < MAX_WORD_LENGTH; i++) {
      if (frequency[i] > 0) {
        uniqueFrequencyCount++;
      }

      // Case "abcc": Unique frequency = (1, 2), where frequency x2 - x1 = 1 and frequency x2 only appeared once
      if (frequency[i] > 0 && frequency[i + 1] > 0 && frequency[i + 1] == 1) {
        hasAdjacentFrequency = true;
      }
    }

    // Invalid string: "aaaabbbbccc", "aazz", "ddaccb"
    // Valid strong: "abcc", "abc", "abbcc", "cccd", "zz"
    return (
      // Case "abcc", plus make sure "abccdd" does not exists as deleting one 'c' will result in "abcdd" and deleting 'd' will result in "abccd"
      (uniqueFrequencyCount == 2 && hasAdjacentFrequency)
      // Case "cccd": Deleting d makes frequency (3) the only frequency
      || (uniqueFrequencyCount == 2 && frequency[1] == 1)
      // Case "abc": Deleting any one of the char will make frequency equal
      || (uniqueFrequencyCount == 1 && frequency[1] > 0)
    );
  }
}

class Solution {
  private boolean isVowel(char c) {
    return (
      c == 'a'
      || c == 'e'
      || c == 'i'
      || c == 'o'
      || c == 'u'
    );
  }

  private boolean hasAllVowels(int[] frequency) {
    return (
      frequency['a' - 'a'] >= 1
      && frequency['e' - 'a'] >= 1
      && frequency['i' - 'a'] >= 1
      && frequency['o' - 'a'] >= 1
      && frequency['u' - 'a'] >= 1
    );
  }

  private long count(char[] characters, int k) {
    int n = characters.length;
    int[] vowelCount = new int[26];
    int consonantsCount = 0;
    int left = 0;
    int right = 0;
    long result = 0;

    while (right < n) {
      if (isVowel(characters[right])) {
        vowelCount[characters[right] - 'a']++;
      } else {
        consonantsCount++;
      }

      while (hasAllVowels(vowelCount) && consonantsCount >= k) {
        result += n - right;

        if (isVowel(characters[left])) {
          vowelCount[characters[left] - 'a']--;
        } else {
          consonantsCount--;
        }

        left++;
      }

      right++;
    }

    return result;
  }

  public long countOfSubstrings(String word, int k) {
    char[] characters = word.toCharArray();
    return count(characters, k) - count(characters, k + 1);
  }
}

class Solution {
  private boolean isVowels(char c) {
    return (
      c == 'a'
      || c == 'e'
      || c == 'i'
      || c == 'o'
      || c == 'u'
    );
  }

  public int maxVowels(String s, int k) {
    char[] characters = s.toCharArray();
    int n = characters.length;
    int count = 0;
    int maxCount = 0;

    for (int i = 0; i < n; i++) {
      if (isVowels(characters[i])) {
        count++;
      }

      if (i > k - 1 && isVowels(characters[i - k])) {
        count--;
      }

      if (i >= k - 1) {
        maxCount = Math.max(maxCount, count);
      }
    }

    return maxCount;
  }
}

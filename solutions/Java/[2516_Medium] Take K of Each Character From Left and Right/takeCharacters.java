class Solution {
  public int takeCharacters(String s, int k) {
    char[] characters = s.toCharArray();
    int[] frequency = new int[3];
    for (char c: characters) {
      frequency[c - 'a']++;
    }
    if (frequency[0] < k || frequency[1] < k || frequency[2] < k) {
      return -1;
    }

    int maxLength = 0;
    int left = 0;

    for (int right = 0; right < characters.length; right++) {
      int c = characters[right] - 'a';
      frequency[c]--;

      while (frequency[c] < k) {
        frequency[characters[left] - 'a']++;
        left++;
      }

      maxLength = Math.max(maxLength, right - left + 1);
    }
    return characters.length - maxLength;
  }
}

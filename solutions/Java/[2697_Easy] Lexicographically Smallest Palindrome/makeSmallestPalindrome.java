class Solution {
  public String makeSmallestPalindrome(String s) {
    char[] characters = s.toCharArray();
    int n = characters.length;
    int start = 0;
    int end = n - 1;

    while (start < end) {
      if (characters[start] != characters[end]) {
        if (characters[start] < characters[end]) {
          characters[end] = characters[start];
        } else {
          characters[start] = characters[end];
        }
      }

      start++;
      end--;
    }

    return new String(characters);
  }
}

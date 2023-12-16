class Solution {
  public boolean isPalindrome(String s) {
    char[] characters = s.toCharArray();
    int start = 0;
    int end = characters.length - 1;

    while (start < end) {
      if (characters[start] != characters[end]) {
        return false;
      }

      start++;
      end--;
    }

    return true;
  }

  public String firstPalindrome(String[] words) {
    for (String w: words) {
      if (isPalindrome(w)) {
        return w;
      }
    }

    return "";
  }
}

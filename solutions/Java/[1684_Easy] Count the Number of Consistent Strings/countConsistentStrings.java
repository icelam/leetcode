class Solution {
  public int countConsistentStrings(String allowed, String[] words) {
    boolean[] allowedChar = new boolean[26];
    int count = 0;

    for (char c: allowed.toCharArray()) {
      allowedChar[c - 'a'] = true;
    }

    for (String w: words) {
      boolean isValid = true;

      for (char c: w.toCharArray()) {
        if (!allowedChar[c - 'a']) {
          isValid = false;
          break;
        }
      }

      if (isValid) {
        count++;
      }
    }

    return count;
  }
}

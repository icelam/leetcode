class Solution {
  public boolean canMakeSubsequence(String str1, String str2) {
    int m = str1.length();
    int n = str2.length();

    if (m < n) {
      return false;
    }

    char[] s1 = str1.toCharArray();
    char[] s2 = str2.toCharArray();
    int i = 0;

    for (char currentChar : s1) {
      char nextChar = currentChar;

      if (currentChar == 'z') {
        nextChar = 'a';
      } else {
        nextChar = (char) (currentChar + 1);
      }

      if (currentChar == s2[i] || nextChar == s2[i]) {
        i++;

        if (i == n) {
          return true;
        }
      }
    }

    return false;
  }
}

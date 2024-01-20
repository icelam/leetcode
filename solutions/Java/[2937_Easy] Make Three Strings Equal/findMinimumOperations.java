class Solution {
  public int findMinimumOperations(String s1, String s2, String s3) {
    int shortestWordLength = Math.min(s1.length(), Math.min(s2.length(), s3.length()));
    int pointer = 0;

    while (
      pointer < shortestWordLength
      && s1.charAt(pointer) == s2.charAt(pointer)
      && s2.charAt(pointer) == s3.charAt(pointer)
    ) {
      pointer++;
    }

    if (pointer == 0) {
      return -1;
    }

    return (s1.length() - pointer) + (s2.length() - pointer) + (s3.length() - pointer);
  }
}

class Solution {
  public int partitionString(String s) {
    char[] characters = s.toCharArray();
    int n = characters.length;
    int pointer = 0;
    int result = 0;

    while (pointer < n) {
      int[] frequency = new int[26];

      while (pointer < n && frequency[characters[pointer] - 'a'] == 0) {
        frequency[characters[pointer] - 'a']++;
        pointer++;
      }

      result++;
    }

    return result;
  }
}

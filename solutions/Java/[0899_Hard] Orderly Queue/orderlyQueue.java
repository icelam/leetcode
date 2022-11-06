class Solution {
  public String orderlyQueue(String s, int k) {
    if (k == 1) {
      String result = s;

      for (int i = 0; i < s.length(); ++i) {
        String nextPossibleSort = s.substring(i) + s.substring(0, i);
        if (nextPossibleSort.compareTo(result) < 0) {
          result = nextPossibleSort;
        }
      }

      return result;
    }

    char[] sortedCharacters = s.toCharArray();
    Arrays.sort(sortedCharacters);
    return new String(sortedCharacters);
  }
}

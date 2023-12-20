class Solution {
  public List<List<Integer>> largeGroupPositions(String s) {
    List<List<Integer>> result = new ArrayList<>();
    int start = 0;
    int end = 0;
    char[] characters = s.toCharArray();
    int n = characters.length;

    while (end < n) {
      while (end < n && characters[end] == characters[start]) {
        end++;
      }

      if (end - start >= 3) {
        List<Integer> pair = new ArrayList<>();
        pair.add(start);
        pair.add(end - 1);
        result.add(pair);
      }

      start = end;
    }

    return result;
  }
}

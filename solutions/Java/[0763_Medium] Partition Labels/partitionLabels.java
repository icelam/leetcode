class Solution {
  public List<Integer> partitionLabels(String s) {
    int[] lastIndex = new int[26];

    for (int i = 0; i < s.length(); i++) {
      lastIndex[s.charAt(i) - 'a'] = i;
    }

    List<Integer> result = new ArrayList<>();
    boolean readyToSplit = true;

    int start = 0;
    int end = 0;

    for (int j = 0; j < s.length(); j++) {
      end = Math.max(end, lastIndex[s.charAt(j) - 'a']);

      if (j == end) {
        result.add(j + 1 - start);
        start = j + 1;
      }
    }

    return result;
  }
}

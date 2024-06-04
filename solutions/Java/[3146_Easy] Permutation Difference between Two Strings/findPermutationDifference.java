class Solution {
  public int findPermutationDifference(String s, String t) {
    int n = s.length();
    char[] soruce = s.toCharArray();
    char[] target = t.toCharArray();
    int[] sIndices = new int[26];
    int result = 0;

    for (int i = 0; i < n; i++) {
      sIndices[soruce[i] - 'a'] = i;
    }

    for (int i = 0; i < n; i++) {
      result += Math.abs(sIndices[target[i] - 'a'] - i);
    }

    return result;
  }
}

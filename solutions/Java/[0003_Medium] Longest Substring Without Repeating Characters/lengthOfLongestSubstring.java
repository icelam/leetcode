class Solution {
  public int lengthOfLongestSubstring(String s) {
    int n = s.length();

    if (n == 0) {
      return 0;
    }

    int result = 1;
    int start = 0;
    int[] indices = new int[128];
    Arrays.fill(indices, -1);

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (indices[c] != -1) {
        start = Math.max(start, indices[c] + 1);
      }

      indices[c] = i;
      result = Math.max(result, (i - start + 1));
    }

    return result;
  }
}

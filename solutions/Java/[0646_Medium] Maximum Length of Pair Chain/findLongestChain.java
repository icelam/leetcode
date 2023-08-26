class Solution {
  public int findLongestChain(int[][] pairs) {
    Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

    int result = 0;
    int right = Integer.MIN_VALUE;

    for (int[] chain: pairs) {
      if (chain[0] <= right) {
        continue;
      }

      result++;
      right = chain[1];
    }

    return result;
  }
}

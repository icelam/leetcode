class Solution {
  public int minFlipsMonoIncr(String s) {
    char[] characters = s.toCharArray();

    int n = s.length();
    int[] prefixSum = new int[n + 1];

    for (int i = 0; i < n; i++) {
      prefixSum[i + 1] = prefixSum[i] + (characters[i] - '0');
    }

    int result = Integer.MAX_VALUE;

    for (int i = 0; i <= n; i++) {
      result = Math.min(result, prefixSum[i] + (n - i - (prefixSum[n] - prefixSum[i])));
    }

    return result;
  }
}

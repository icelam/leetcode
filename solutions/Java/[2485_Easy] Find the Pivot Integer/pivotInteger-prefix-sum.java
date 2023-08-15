class Solution {
  public int pivotInteger(int n) {
    int sum = 0;
    int[] prefixSum = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      sum += i;
      prefixSum[i] = prefixSum[i - 1] + i;
    }

    for (int i = n; i >= 1; i--) {
      if (sum - prefixSum[i - 1] == prefixSum[i]) {
        return i;
      }
    }

    return -1;
  }
}

class Solution {
  public int countTriplets(int[] arr) {
    int n = arr.length;
    int[] prefixSum = new int[n + 1];

    for (int i = 0; i < n; i++) {
      prefixSum[i + 1] = prefixSum[i] ^ arr[i];
    }

    int result = 0;

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (prefixSum[i] == prefixSum[j + 1]) {
          result += j - i;
        }
      }
    }

    return result;
  }
}

class Solution {
  public long putMarbles(int[] weights, int k) {
    if (k == 1) {
      return 0;
    }

    int n = weights.length;
    int[] pairWeights = new int[n - 1];

    for (int i = 0; i < n - 1; i++) {
      pairWeights[i] = (weights[i] + weights[i + 1]);
    }

    Arrays.sort(pairWeights);

    long result = 0;
    int numberOfPairs = n - 1;

    for (int i = numberOfPairs - (k - 1); i < numberOfPairs; i++) {
      result += pairWeights[i];
    }

    for (int i = 0; i < k - 1; i++) {
      result -= pairWeights[i];
    }

    return result;
  }
}

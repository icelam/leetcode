class Solution {
  public long maximumHappinessSum(int[] happiness, int k) {
    int n = happiness.length;
    long result = 0;

    Arrays.sort(happiness);

    for (int i = 0, j = n - 1; i < k; i++, j--) {
      result += Math.max(0, happiness[j] - i);
    }

    return result;
  }
}

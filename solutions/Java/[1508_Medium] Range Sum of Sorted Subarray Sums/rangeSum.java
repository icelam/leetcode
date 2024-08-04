class Solution {
  private static int MOD = (int) 1e9 + 7;

  public int rangeSum(int[] nums, int n, int left, int right) {
    int m = (n * (n + 1)) / 2;
    int[] subarraySum = new int[m];
    int index = 0;

    for (int i = 0; i < n; i++) {
      int sum = 0;

      for (int j = i; j < n; j++, index++) {
        sum += nums[j];
        subarraySum[index] = sum;
      }
    }

    Arrays.sort(subarraySum);

    int result = 0;

    for (int i = left - 1; i < right; i++) {
      result = (result + subarraySum[i]) % MOD;
    }

    return result;
  }
}

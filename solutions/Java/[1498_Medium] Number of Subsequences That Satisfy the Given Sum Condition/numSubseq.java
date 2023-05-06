class Solution {
  private static int MOD = (int) (1e9 + 7);

  public int numSubseq(int[] nums, int target) {
    int n = nums.length;
    int start = 0;
    int end = n - 1;
    long result = 0;

    // Preprocess 2^n as Math.pow will have overflow
    int[] f = new int[n];
    f[0] = 1;

    for (int i = 1; i < n; ++i) {
      f[i] = (f[i - 1] << 1) % MOD;
    }

    // Order in sequence does not affect number of subsequence that matches
    Arrays.sort(nums);

    while (start <= end) {
      int sum = nums[start] + nums[end];
      if (sum > target) {
        end--;
      } else {
        result = (result + f[end - start]) % MOD;
        start++;
      }
    }

    return (int) result;
  }
}

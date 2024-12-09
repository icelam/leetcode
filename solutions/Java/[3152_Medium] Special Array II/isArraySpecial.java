class Solution {
  public boolean[] isArraySpecial(int[] nums, int[][] queries) {
    int n = nums.length;
    int m = queries.length;
    boolean[] result = new boolean[queries.length];
    int[] prefix = new int[n];

    prefix[0] = 0;

    for (int i = 1; i < n; i++) {
      if (nums[i] % 2 == nums[i - 1] % 2) {
        prefix[i] = prefix[i - 1] + 1;
      } else {
        prefix[i] = prefix[i - 1];
      }
    }

    for (int i = 0; i < m; i++) {
      int[] query = queries[i];
      int start = query[0];
      int end = query[1];
      result[i] = prefix[end] - prefix[start] == 0;
    }

    return result;
  }
}

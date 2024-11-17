class Solution {
  public int shortestSubarray(int[] nums, int k) {
    int n = nums.length;
    long[] prefixSum = new long[n + 1];

    for (int i = 0; i < n; i++) {
      prefixSum[i + 1] = prefixSum[i] + nums[i];
    }

    int result = n + 1;
    Deque<Integer> queue = new ArrayDeque<Integer>();

    for (int i = 0; i <= n; i++) {
      long currentSum = prefixSum[i];

      while (!queue.isEmpty() && currentSum - prefixSum[queue.peekFirst()] >= k) {
        result = Math.min(result, i - queue.pollFirst());
      }

      while (!queue.isEmpty() && prefixSum[queue.peekLast()] >= currentSum) {
        queue.pollLast();
      }

      queue.offerLast(i);
    }

    return result < n + 1 ? result : -1;
  }
}

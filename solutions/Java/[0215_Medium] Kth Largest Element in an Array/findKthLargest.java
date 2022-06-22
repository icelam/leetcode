class Solution {
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<>();

    for (int i = 0; i < nums.length; i++) {
      heap.offer(nums[i]);

      if (i + 1 > k) {
        heap.remove();
      }
    }

    return heap.peek();
  }
}

class Solution {
  public int minOperations(int[] nums, int k) {
    PriorityQueue<Long> pq = new PriorityQueue<>();

    for (int value: nums) {
      pq.add((long) value);
    }

    int operations = 0;

    while (pq.peek() < k) {
      operations++;

      long min1 = pq.remove();
      long min2 = pq.remove();

      if (min1 > min2) {
        long temp = min1;
        min1 = min2;
        min2 = temp;
      }

      pq.add(min1 * 2 + min2);
    }

    return operations;
  }
}

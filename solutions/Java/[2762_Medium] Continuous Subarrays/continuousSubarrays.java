class Solution {
  public long continuousSubarrays(int[] nums) {
    int n = nums.length;
    Deque<Integer> maxQueue = new LinkedList<>();
    Deque<Integer> minQueue = new LinkedList<>();
    long result = 0;
    int left = 0;

    for (int right = 0; right < n; right++) {
      while (!maxQueue.isEmpty() && maxQueue.peekLast() < nums[right]) {
        maxQueue.removeLast();
      }

      maxQueue.add(nums[right]);

      while (!minQueue.isEmpty() && minQueue.peekLast() > nums[right]) {
        minQueue.removeLast();
      }

      minQueue.add(nums[right]);

      while (!maxQueue.isEmpty() && !minQueue.isEmpty() && maxQueue.peek() - minQueue.peek() > 2) {
        if (maxQueue.peek() == nums[left]) {
          maxQueue.remove();
        }

        if (minQueue.peek() == nums[left]) {
          minQueue.remove();
        }

        left++;
      }

      result += right - left + 1;
    }

    return result;
  }
}

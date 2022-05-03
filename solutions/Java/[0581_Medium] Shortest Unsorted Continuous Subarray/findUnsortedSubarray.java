class Solution {
  public int findUnsortedSubarray(int[] nums) {
    Stack<Integer> stack = new Stack<>();
    int start = -1;
    int end = -1;
    int popMin = Integer.MAX_VALUE;
    int popMax = Integer.MIN_VALUE;

    for (int i = 0; i < nums.length; i++) {
      while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
        int lastIndex = stack.peek();
        popMin = Math.min(nums[lastIndex], popMin);
        popMax = Math.max(nums[lastIndex], popMax);

        if (start == -1 || lastIndex < start) {
          start = lastIndex;
        }

        stack.pop();
      }

      if ((i > 0 && nums[i] < nums[i - 1]) || (nums[i] >= popMin && nums[i] < popMax)) {
        end = i;
        popMin = Math.min(nums[i], popMin);
        popMax = Math.max(nums[i], popMax);
      } else {
        stack.add(i);
      }
    }

    return start > -1 ? end - start + 1 : 0;
  }
}

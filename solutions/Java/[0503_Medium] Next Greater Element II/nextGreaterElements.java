class Solution {
  public int[] nextGreaterElements(int[] nums) {
    int[] result = new int[nums.length];
    Stack<Integer> stack = new Stack<>();
    int size = nums.length;

    for (int i = (size * 2) - 1; i >= 0; i--) {
      while (!stack.isEmpty() && nums[i % size] >= stack.peek()) {
        stack.pop();
      }
      result[i % size] = stack.isEmpty() ? -1 : stack.peek();
      stack.push(nums[i % size]);
    }

    return result;
  }
}

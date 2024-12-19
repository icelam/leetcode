class Solution {
  public int maxChunksToSorted(int[] arr) {
    Stack<Integer> stack = new Stack<>();

    for (int value: arr) {
      if (stack.isEmpty() || value > stack.peek()) {
        stack.push(value);
        continue;
      }

      int max = stack.peek();

      while (!stack.isEmpty() && value < stack.peek()) {
        stack.pop();
      }

      stack.push(max);
    }

    return stack.size();
  }
}

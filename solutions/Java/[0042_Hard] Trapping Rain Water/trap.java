class Solution {
  public int trap(int[] height) {
    int result = 0;
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < height.length; i++) {
      while (!stack.empty() && height[i] > height[stack.peek()]) {
        int previous = stack.pop();

        if (stack.empty()) {
          break;
        }

        int distance = i - stack.peek() - 1;
        int trappedRain = Math.min(height[i], height[stack.peek()]) - height[previous];
        result += distance * trappedRain;
      }

      stack.push(i);
    }

    return result;
  }
}

class Solution {
  public int[] canSeePersonsCount(int[] heights) {
    int[] result = new int[heights.length];
    Stack<Integer> viewable = new Stack<>();

    for (int i = heights.length - 1; i >= 0; i--) {
      while (!viewable.empty() && heights[i] > viewable.peek()) {
        viewable.pop();
        result[i]++;
      }

      if (!viewable.empty()) {
        result[i]++;
      }

      viewable.push(heights[i]);
    }

    return result;
  }
}

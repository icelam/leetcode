class Solution {
  public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
    int n = obstacles.length;

    int top = 0;
    int[] stack = new int[n];
    stack[0] = obstacles[0];

    int[] result = new int[n];
    result[0] = top + 1;

    for (int i = 1; i < n; i++) {
      int left = 0;
      int right = top;
      int middle = 0;

      if (obstacles[i] < stack[top]) {
        while (left < right) {
          middle = left + (right - left) / 2;
          if (stack[middle] <= obstacles[i]) {
            left = middle + 1;
          } else {
            right = middle;
          }
        }
      } else {
        top++;
        right++;
      }

      stack[right] = obstacles[i];
      result[i] = right + 1;
    }

    return result;
  }
}

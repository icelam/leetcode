class Solution {
  private static int MOD = (int) (1e9 + 7);

  public int sumSubarrayMins(int[] arr) {
    int n = arr.length;
    int[] left = new int[n];
    int[] right = new int[n];

    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
        stack.pop();
      }

      if (stack.isEmpty()) {
        left[i] = -1;
      } else {
        left[i] = stack.peek();
      }

      stack.push(i);
    }

    stack.clear();

    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
        stack.pop();
      }

      if (stack.isEmpty()) {
        right[i] = n;
      } else {
        right[i] = stack.peek();
      }

      stack.push(i);
    }

    long result = 0;

    for (int i = 0; i < n; i++) {
      result = (result + (long) (i - left[i]) * (right[i] - i) * arr[i]) % MOD;
    }

    return (int) result;
  }
}

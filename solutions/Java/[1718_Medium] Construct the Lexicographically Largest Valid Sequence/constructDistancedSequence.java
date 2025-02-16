class Solution {
  private int n;
  private int m;
  private int[] result;
  private boolean[] visited;

  private boolean backtrack(int index) {
    if (index == m) {
      return true;
    }

    if (result[index] != 0) {
      return backtrack(index + 1);
    }

    for (int digit = n; digit >= 1; digit--) {
      if (visited[digit]) {
        continue;
      }

      visited[digit] = true;
      result[index] = digit;

      if (digit == 1) {
        if (backtrack(index + 1)) {
          return true;
        }
      } else if (index + digit < m && result[index + digit] == 0) {
        result[index + digit] = digit;

        if (backtrack(index + 1)) {
          return true;
        }

        result[index + digit] = 0;
      }

      visited[digit] = false;
      result[index] = 0;
    }

    return false;
  }

  public int[] constructDistancedSequence(int n) {
    this.n = n;
    this.m = 2 * n - 1;
    this.result = new int[m];
    this.visited = new boolean[n + 1];

    backtrack(0);
    return result;
  }
}

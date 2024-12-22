class Solution {
  private int binarySearch(int[] heights, int[] monoStack, int right, int target) {
    int left = -1;

    while (left + 1 < right) {
      int middle = (left + right) / 2;

      if (heights[monoStack[middle]] > target) {
        left = middle;
      } else {
        right = middle;
      }
    }

    return left < 0 ? -1 : monoStack[left];
  }

  public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
    int n = heights.length;
    int[] result = new int[queries.length];
    List<int[]>[] transformedQueries = new ArrayList[n];
    Arrays.setAll(transformedQueries, i -> new ArrayList<>());

    for (int i = 0; i < queries.length; i++) {
      int a = queries[i][0];
      int b = queries[i][1];

      if (a > b) {
        int tmp = a;
        a = b;
        b = tmp;
      }

      if (a == b || heights[a] < heights[b]) {
        result[i] = b;
        continue;
      }

      transformedQueries[b].add(new int[] {heights[a], i});
    }

    int[] monoStack = new int[n];
    int top = 0;

    for (int i = n - 1; i >= 0; i--) {
      for (int[] q : transformedQueries[i]) {
        result[q[1]] = binarySearch(heights, monoStack, top, q[0]);
      }

      while (top > 0 && heights[i] >= heights[monoStack[top - 1]]) {
        top--;
      }

      monoStack[top++] = i;
    }
    return result;
  }
}

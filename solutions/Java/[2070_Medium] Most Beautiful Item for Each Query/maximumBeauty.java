class Solution {
  private int binarySearch(int[][] items, int targetPrice) {
    int left = 0;
    int right = items.length - 1;
    int maxBeauty = 0;

    while (left <= right) {
      int middle = left + (right - left) / 2;

      if (items[middle][0] > targetPrice) {
        right = middle - 1;
      } else {
        maxBeauty = Math.max(maxBeauty, items[middle][1]);
        left = middle + 1;
      }
    }

    return maxBeauty;
  }

  public int[] maximumBeauty(int[][] items, int[] queries) {
    int m = queries.length;
    int[] result = new int[m];

    Arrays.sort(items, (a, b) -> a[0] - b[0]);
    int maxBeauty = items[0][1];

    for (int i = 0; i < items.length; i++) {
      maxBeauty = Math.max(maxBeauty, items[i][1]);
      items[i][1] = maxBeauty;
    }

    for (int i = 0; i < m; i++) {
      result[i] = binarySearch(items, queries[i]);
    }

    return result;
  }
}

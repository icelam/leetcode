class Solution {
  public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
    Arrays.sort(horizontalCuts);
    Arrays.sort(verticalCuts);

    int m = horizontalCuts.length;
    int n = verticalCuts.length;

    int maxHorizontalCuts = Math.max(horizontalCuts[0], h - horizontalCuts[m - 1]);
    int maxVerticalCuts = Math.max(verticalCuts[0], w - verticalCuts[n - 1]);

    for (int i = 1; i < m; i++) {
       maxHorizontalCuts = Math.max(maxHorizontalCuts, horizontalCuts[i] - horizontalCuts[i - 1]);
    }

    for (int j = 1; j < n; j++) {
      maxVerticalCuts = Math.max(maxVerticalCuts, verticalCuts[j] - verticalCuts[j - 1]);
    }

    long result = (long) maxHorizontalCuts * maxVerticalCuts;
    return (int) (result % 1_000_000_007);
  }
}

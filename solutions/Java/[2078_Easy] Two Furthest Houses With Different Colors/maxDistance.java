class Solution {
  public int maxDistance(int[] colors) {
    int n = colors.length;
    int start = 0;
    int end = n - 1;

    while (colors[start] == colors[0]) {
      start++;
    }

    while (colors[end] == colors[0]) {
      end--;
    }

    return n - Math.min(start, (n - 1 - end)) - 1;
  }
}

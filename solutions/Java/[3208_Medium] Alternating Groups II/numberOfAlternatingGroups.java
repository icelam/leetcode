class Solution {
  public int numberOfAlternatingGroups(int[] colors, int k) {
    int n = colors.length;
    int result = 0;
    int left = 0;
    int right = 1;

    while (right < n + k - 1) {
      if (colors[right % n] == colors[(right - 1) % n]) {
        left = right;
        right++;
        continue;
      }

      right++;

      if (right - left == k){
        result++;
        left++;
      }
    }

    return result;
  }
}

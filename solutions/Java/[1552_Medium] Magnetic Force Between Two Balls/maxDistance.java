class Solution {
  // Check if m balls can be placed for a certain minimum magnetic force
  private boolean canPlace(int[] position, int force, int m) {
    int n = position.length;
    int previousPosition = position[0];
    int count = 1;

    for (int i = 1; i < n; i++) {
      if (position[i] - previousPosition >= force) {
        previousPosition = position[i];
        count++;
      }
    }

    return count >= m;
  }

  public int maxDistance(int[] position, int m) {
    int n = position.length;
    Arrays.sort(position);

    // When minimum magnetic force increases, number of balls can be placed will decrease.
    // Use binary search to search for max(minimum magnetic force) which can place m balls.
    int left = 1;
    int right = position[n - 1] - position[0];

    while (left <= right) {
      int middle = left + (right - left) / 2;

      if (canPlace(position, middle, m)) {
        left = middle + 1;
      } else {
        right = middle - 1;
      }
    }
    return left - 1;
  }
}

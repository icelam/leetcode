class Solution {
  private boolean canDistribute(int[] candies, int i, long k) {
    long sum = 0;

    for (int candiesCount : candies) {
      sum += candiesCount / i;
    }

    return sum >= k;
  }

  public int maximumCandies(int[] candies, long k) {
    int left = 1;
    int right = 1 + Arrays.stream(candies).max().getAsInt();

    while (left < right) {
      int middle = left + (right - left) / 2;

      if (canDistribute(candies, middle, k)) {
        left = middle + 1;
      } else {
        right = middle;
      }
    }
    return left - 1;
  }
}

class Solution {
  private int getCount(int prefix, int n) {
    int count =  0;
    long current = prefix;
    long next = prefix + 1;

    while (current <= n) {
      count += Math.min(next, n + 1) - current;
      current *= 10;
      next *= 10;
    }

    return count;
  }

  public int findKthNumber(int n, int k) {
    int prefix = 1;
    int totalCount = 1;

    while (totalCount < k) {
      int currentCount = getCount(prefix, n);

      if (totalCount + currentCount > k) {
        prefix *= 10;
        totalCount++;
      } else {
        prefix++;
        totalCount += currentCount;
      }
    }

    return prefix;
  }
}

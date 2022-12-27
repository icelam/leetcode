class Solution {
  public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
    int n = capacity.length;
    int[] freeSpace = new int[n];

    for (int i = 0; i < n; i++) {
      freeSpace[i] = capacity[i] - rocks[i];
    }

    Arrays.sort(freeSpace);

    int result = 0;

    for (int j = 0; j < n && additionalRocks >= freeSpace[j]; j++) {
      additionalRocks -= freeSpace[j];
      result++;
    }

    return result;
  }
}

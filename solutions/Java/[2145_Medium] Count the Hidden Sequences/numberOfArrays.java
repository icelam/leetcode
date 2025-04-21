class Solution {
  public int numberOfArrays(int[] differences, int lower, int upper) {
    int min = 0;
    int max = 0;
    int diffSum = 0;

    for (int currentDiff : differences) {
      diffSum += currentDiff;
      min = Math.min(min, diffSum);
      max = Math.max(max, diffSum);

      if (max - min > upper - lower) {
        return 0;
      }
    }
    return (upper - lower) - (max - min) + 1;
  }
}

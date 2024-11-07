class Solution {
  public int largestCombination(int[] candidates) {
    int[] setBitFrequency = new int[24];

    for (int num: candidates) {
      int i = 0;

      while (num > 0) {
        setBitFrequency[i] += num & 1;
        num >>= 1;
        i++;
      }
    }

    int largestCombination = 0;

    for (int frequency: setBitFrequency) {
      largestCombination = Math.max(largestCombination, frequency);
    }

    return largestCombination;
  }
}

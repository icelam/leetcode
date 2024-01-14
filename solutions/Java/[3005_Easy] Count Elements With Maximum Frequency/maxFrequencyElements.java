class Solution {
  public int maxFrequencyElements(int[] nums) {
    int[] frequency = new int[101];
    int maxFrequency = 0;

    for (int value: nums) {
      frequency[value]++;
      maxFrequency = Math.max(maxFrequency, frequency[value]);
    }

    int count = 0;

    for (int f: frequency) {
      if (f == maxFrequency) {
        count++;
      }
    }

    return maxFrequency * count;
  }
}

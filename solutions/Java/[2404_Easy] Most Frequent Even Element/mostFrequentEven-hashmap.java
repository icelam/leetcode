class Solution {
  public int mostFrequentEven(int[] nums) {
    HashMap<Integer, Integer> frequency = new HashMap<>();

    for (int n: nums) {
      if (n % 2 == 0) {
        frequency.put(n, frequency.getOrDefault(n, 0) + 1);
      }
    }

    int maxFrequency = Integer.MIN_VALUE;
    int result = Integer.MAX_VALUE;

    for (int n: frequency.keySet()) {
      int currentFrequency = frequency.get(n);
      if (maxFrequency == currentFrequency && n < result) {
        result = n;
      } else if (currentFrequency > maxFrequency) {
        result = n;
        maxFrequency = currentFrequency;
      }
    }

    return result == Integer.MAX_VALUE ? -1 : result;
  }
}

class Solution {
  public int minOperations(int[] nums) {
    HashMap<Integer, Integer> frequency = new HashMap<>();

    for (int n: nums) {
      frequency.put(n, frequency.getOrDefault(n, 0) + 1);
    }

    int minOperations = 0;

    for (double count: frequency.values()) {
      if (count == 1) {
        return -1;
      }

      minOperations += Math.ceil(count / 3);
    }

    return minOperations;
  }
}

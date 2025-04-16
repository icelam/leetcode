class Solution {
  public long countGood(int[] nums, int k) {
    long result = 0;
    HashMap<Integer, Integer> frequency = new HashMap<>();
    int totalPairs = 0;
    int left = 0;

    for (int value : nums) {
      int count = frequency.getOrDefault(value, 0);
      totalPairs += count;
      frequency.put(value, count + 1);

      while (totalPairs >= k) {
        value = nums[left];
        count = frequency.get(value);
        totalPairs -= count - 1;
        frequency.put(value, count - 1);
        left++;
      }

      result += left;
    }

    return result;
  }
}

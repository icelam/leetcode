class Solution {
  public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
    int n = nums.size();
    HashMap<Integer, Integer> count = new HashMap<>();
    long result = 0;
    int prefixSum = 0;
    count.put(0, 1);

    for (int value: nums) {
      if (value % modulo == k) {
        prefixSum++;
      }

      result += count.getOrDefault((prefixSum - k + modulo) % modulo, 0);
      count.put(prefixSum % modulo, count.getOrDefault(prefixSum % modulo, 0) + 1);
    }

    return result;
  }
}

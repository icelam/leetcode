class Solution {
  public long countBadPairs(int[] nums) {
    int n = nums.length;
    HashMap<Integer, Integer> diffFrequency = new HashMap<>();
    long result = ((long) n) * (n - 1) / 2;

    for (int i = 0; i < n; i++) {
      int diff = nums[i] - i;
      result -= diffFrequency.getOrDefault(diff, 0);
      diffFrequency.put(diff, diffFrequency.getOrDefault(diff, 0) + 1);
    }

    return result;
  }
}

class Solution {
  public int minOperations(int[] nums, int k) {
    HashSet<Integer> set = new HashSet<>();

    for (int value: nums) {
      if (value < k) {
        return -1;
      }

      if (value == k) {
        continue;
      }

      set.add(value);
    }

    return set.size();
  }
}

class Solution {
  public int arithmeticTriplets(int[] nums, int diff) {
    HashSet<Integer> set = new HashSet<>();
    int result = 0;

    for (int value : nums) {
      set.add(value);

      if (set.contains(value - diff) && set.contains(value - 2 * diff)) {
        result++;
      }
    }

    return result;
  }
}

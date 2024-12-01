class Solution {
  public int findFinalValue(int[] nums, int original) {
    HashSet<Integer> set = new HashSet<>();

    for (int value: nums) {
      set.add(value);
    }

    while (set.contains(original)) {
      original *= 2;
    }

    return original;
  }
}

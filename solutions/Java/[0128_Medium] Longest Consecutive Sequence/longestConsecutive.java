class Solution {
  public int longestConsecutive(int[] nums) {
    int maxCount = 0;
    HashSet<Integer> set = new HashSet();

    for (int n: nums) {
      set.add(n);
    }

    for (int n: set) {
      if (set.contains(n - 1)) {
        continue;
      }

      int count = 1;

      while (set.contains(++n)) {
        count++;
      }

      maxCount = Math.max(maxCount, count);
    }

    return maxCount;
  }
}

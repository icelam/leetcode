class Solution {
  public int longestSquareStreak(int[] nums) {
    Map<Integer, Integer> streakCache = new HashMap<>();

    Arrays.sort(nums);

    for (int number : nums) {
      int root = (int) Math.sqrt(number);

      if (root * root == number && streakCache.containsKey(root)) {
        streakCache.put(number, streakCache.get(root) + 1);
      } else {
        streakCache.put(number, 1);
      }
    }

    int result = 0;

    for (int currentStreak : streakCache.values()) {
      result = Math.max(result, currentStreak);
    }

    return result == 1 ? -1 : result;
  }
}

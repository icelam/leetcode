class Solution {
  public int longestMonotonicSubarray(int[] nums) {
    int previous = Integer.MIN_VALUE;
    int streak = 0;
    int maxStreak = 0;

    for (int value: nums) {
      if (value > previous) {
        streak++;
        maxStreak = Math.max(maxStreak, streak);
      } else {
        streak = 1;
      }

      previous = value;
    }

    previous = Integer.MAX_VALUE;
    streak = 0;

    for (int value: nums) {
      if (value < previous) {
        streak++;
        maxStreak = Math.max(maxStreak, streak);
      } else {
        streak = 1;
      }

      previous = value;
    }

    return maxStreak;
  }
}

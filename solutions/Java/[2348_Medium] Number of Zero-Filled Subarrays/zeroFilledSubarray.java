class Solution {
  public long zeroFilledSubarray(int[] nums) {
    long result = 0;
    int streak = 0;

    for (int n: nums) {
      if (n != 0) {
        streak = 0;
        continue;
      }

      streak++;
      result += streak;
    }

    return result;
  }
}

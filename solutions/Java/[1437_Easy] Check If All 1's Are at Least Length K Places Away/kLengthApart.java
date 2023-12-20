class Solution {
  public boolean kLengthApart(int[] nums, int k) {
    int zeroStreak = k;

    for (int n: nums) {
      if (n == 0) {
        zeroStreak++;
        continue;
      }

      if (zeroStreak < k) {
        return false;
      }

      zeroStreak = 0;
    }

    return true;
  }
}

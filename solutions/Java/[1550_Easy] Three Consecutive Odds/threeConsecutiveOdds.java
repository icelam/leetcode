class Solution {
  public boolean threeConsecutiveOdds(int[] arr) {
    int streak = 0;

    for (int num: arr) {
      if (num % 2 == 1) {
        streak++;
      } else {
        streak = 0;
      }

      if (streak == 3) {
        return true;
      }
    }

    return false;
  }
}

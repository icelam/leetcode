class Solution {
  public int minEatingSpeed(int[] piles, int h) {
    int left = 1;
    int right = 0;

    for (int pile : piles) {
      right = Math.max(right, pile);
    }

    int result = right;

    while (left < right) {
      int speed = left + (right - left) / 2;
      long time = 0;

      for (int pile : piles) {
        time += (pile + speed - 1) / speed;
      }

      if (time <= h) {
        result = speed;
        right = speed;
      } else {
        left = speed + 1;
      }
    }

    return result;
  }
}

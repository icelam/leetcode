class Solution {
  public boolean canAliceWin(int[] nums) {
    int sum1 = 0;
    int sum2 = 0;

    for (int value: nums) {
      if (value < 10) {
        sum1 += value;
      } else {
        sum2 += value;
      }
    }

    return sum1 != sum2;
  }
}

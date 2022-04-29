class Solution {
  public int findNumbers(int[] nums) {
    int count = 0;

    for (int n: nums) {
      int temp = n;
      int digits = 0;

      do {
        digits++;
        temp /= 10;
      } while (temp >= 1);

      if (digits % 2 == 0) {
        count++;
      }
    }

    return count;
  }
}

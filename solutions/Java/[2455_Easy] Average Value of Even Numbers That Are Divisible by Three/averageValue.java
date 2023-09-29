class Solution {
  public int averageValue(int[] nums) {
    int sum = 0;
    int count = 0;

    for (int n: nums) {
      // n % 2 == 0 && n % 3 == 0 is actually finding number divisible by 6
      if (n % 6 == 0) {
        sum += n;
        count++;
      }
    }

    if (count == 0) {
      return 0;
    }

    return sum / count;
  }
}

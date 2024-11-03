class Solution {
  public int minElement(int[] nums) {
    int minElement = Integer.MAX_VALUE;

    for (int value: nums) {
      int sum = 0;

      while (value > 0) {
        sum += value % 10;
        value /= 10;
      }

      minElement = Math.min(minElement, sum);
    }

    return minElement;
  }
}

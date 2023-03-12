class Solution {
  public int findMaxConsecutiveOnes(int[] nums) {
    int max = 0;
    int count = 0;

    for (int n: nums) {
      if (n == 0) {
        max = Math.max(max, count);
        count = 0;
        continue;
      }

      count++;
    }

    return Math.max(max, count);
  }
}

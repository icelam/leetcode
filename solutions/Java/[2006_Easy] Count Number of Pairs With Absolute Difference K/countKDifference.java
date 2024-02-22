class Solution {
  public int countKDifference(int[] nums, int k) {
    int[] frequency = new int[101];
    int result = 0;

    for (int n: nums) {
      frequency[n]++;
    }

    for (int n = k + 1; n < 101; n++) {
      result += frequency[n] * frequency[n - k];
    }

    return result;
  }
}

class Solution {
  public int repeatedNTimes(int[] nums) {
    boolean[] seen = new boolean[10001];

    for (int value: nums) {
      if (seen[value]) {
        return value;
      }

      seen[value] = true;
    }

    return -1;
  }
}

class Solution {
  public int findMaxK(int[] nums) {
    boolean[] seen = new boolean[2001];
    int max = -1;

    for (int num: nums) {
      seen[num + 1000] = true;

      int absoluteNum = Math.abs(num);

      if (
        seen[absoluteNum + 1000]
        && seen[(absoluteNum * -1) + 1000]
        && absoluteNum > max
      ) {
        max = absoluteNum;
      }
    }

    return max;
  }
}

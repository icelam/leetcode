class Solution {
  public int minimumOperations(int[] nums) {
    int n = nums.length;
    boolean[] isSeen = new boolean[101];
    int i = n - 1;

    while (i >= 0) {
      if (isSeen[nums[i]]) {
        return i / 3 + 1;
      }

      isSeen[nums[i]] = true;
      i--;
    }

    return 0;
  }
}

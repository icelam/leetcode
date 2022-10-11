class Solution {
  public boolean increasingTriplet(int[] nums) {
    int i = Integer.MAX_VALUE;
    int j = Integer.MAX_VALUE;

    for (int n: nums) {
      if (i >= n) {
        i = n;
      } else if (j >= n) {
        j = n;
      } else {
        return true;
      }
    }

    return false;
  }
}

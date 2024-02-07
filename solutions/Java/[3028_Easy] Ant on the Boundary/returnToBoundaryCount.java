class Solution {
  public int returnToBoundaryCount(int[] nums) {
    int location = 0;
    int count = 0;

    for (int move: nums) {
      location += move;

      if (location == 0) {
        count++;
      }
    }

    return count;
  }
}

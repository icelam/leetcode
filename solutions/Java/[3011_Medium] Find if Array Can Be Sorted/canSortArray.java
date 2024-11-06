class Solution {
  public boolean canSortArray(int[] nums) {
    int previousBitCount = 0;
    int previousMax = 0;
    int currentMax = 0;

    for (int num : nums) {
      int currentBitCount = Integer.bitCount(num);

      if (currentBitCount == previousBitCount) {
        currentMax = Math.max(currentMax, num);
      } else {
        previousBitCount = currentBitCount;
        previousMax = currentMax;
        currentMax = num;
      }

      if (num < previousMax) {
        return false;
      }
    }
    return true;
  }
}

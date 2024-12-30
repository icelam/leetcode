class Solution {
  public boolean divideArray(int[] nums) {
    int[] frequency = new int[501];

    for (int value: nums) {
      frequency[value]++;
    }

    for (int count: frequency) {
      if (count % 2 != 0) {
        return false;
      }
    }

    return true;
  }
}

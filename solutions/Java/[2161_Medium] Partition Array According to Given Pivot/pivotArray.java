class Solution {
  public int[] pivotArray(int[] nums, int pivot) {
    int n = nums.length;
    int i = 0;
    int[] result = new int[n];


    for (int value: nums) {
      if (value < pivot) {
        result[i] = value;
        i++;
      }
    }

    for (int value: nums) {
      if (value == pivot) {
        result[i] = value;
        i++;
      }
    }

    for (int value: nums) {
      if (value > pivot) {
        result[i] = value;
        i++;
      }
    }

    return result;
  }
}

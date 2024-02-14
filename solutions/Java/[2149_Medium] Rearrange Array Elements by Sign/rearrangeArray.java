class Solution {
  public int[] rearrangeArray(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    int[] indices = new int[2];
    indices[1] = 1;

    for (int value: nums) {
      if (value > 0) {
        result[indices[0]] = value;
        indices[0] += 2;
      } else {
        result[indices[1]] = value;
        indices[1] += 2;
      }
    }

    return result;
  }
}

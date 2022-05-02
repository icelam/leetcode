class Solution {
  public int[] sortArrayByParity(int[] nums) {
    int i = 0;
    int j = nums.length - 1;
    int[] result = new int[nums.length];

    for (int n : nums) {
      if ((n & 1) == 0) {
        result[i] = n;
        i++;
      } else {
        result[j] = n;
        j--;
      }
    }

    return result;
  }
}

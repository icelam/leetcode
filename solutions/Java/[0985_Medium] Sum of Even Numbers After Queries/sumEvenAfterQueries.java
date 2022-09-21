class Solution {
  public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
    int sum = 0;
    int pointer = 0;
    int[] result = new int[queries.length];

    for (int n: nums) {
      sum += (n & 1) == 0 ? n : 0;
    }

    for (int[] q: queries) {
      int index = q[1];
      int valueToAdd = q[0];
      int originalValue = nums[index];
      nums[index] += valueToAdd;
      sum -= (originalValue & 1) == 0 ? originalValue : 0;
      sum += (nums[index] & 1) == 0 ? nums[index] : 0;
      result[pointer] = sum;
      pointer++;
    }

    return result;
  }
}

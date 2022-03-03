class Solution {
  public int arithmeticSumsOne(int n) {
    return (n * (n + 1)) / 2;
  }

  public int numberOfArithmeticSlices(int[] nums) {
    int count = 0;
    int currentLength = 0;

    for (int i = 2; i < nums.length; i++) {
      if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
        currentLength++;
      } else {
        count += arithmeticSumsOne(currentLength);
        currentLength = 0;
      }
    }

    count += arithmeticSumsOne(currentLength);

    return count;
  }
}

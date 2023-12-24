class Solution {
  public int[] separateDigits(int[] nums) {
    int digitCount = 0;

    for (int num: nums) {
      while (num > 0) {
        num /= 10;
        digitCount++;
      }
    }

    int n = nums.length;
    int[] result = new int[digitCount];

    for (int i = n - 1, j = digitCount - 1; i >= 0; i--) {
      int num = nums[i];
      while (num > 0) {
        result[j] = num % 10;
        num /= 10;
        j--;
      }
    }

    return result;
  }
}

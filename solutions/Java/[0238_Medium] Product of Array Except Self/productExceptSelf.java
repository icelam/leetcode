class Solution {
  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] leftProducts = new int[n];
    int[] rightProducts = new int[n];
    leftProducts[0] = 1;
    rightProducts[n - 1] = 1;

    for (int i = 1; i < n; i++) {
      leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
      rightProducts[n - i - 1] = rightProducts[n - i] * nums[n - i];
    }

    int[] result = new int[n];

    for (int i = 0; i < n; i++) {
      result[i] = leftProducts[i] * rightProducts[i];
    }

    return result;
  }
}

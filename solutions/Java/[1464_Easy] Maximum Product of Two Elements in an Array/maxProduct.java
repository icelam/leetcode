class Solution {
  public int maxProduct(int[] nums) {
    int num1 = Integer.MIN_VALUE;
    int num2 = Integer.MIN_VALUE;

    for (int n: nums) {
      if (n > num1) {
        num2 = num1;
        num1 = n;
      } else {
        num2 = Math.max(num2, n);
      }
    }

    return (num1 - 1) * (num2 - 1);
  }
}

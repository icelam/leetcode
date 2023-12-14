class Solution {
  public int minimumSum(int num) {
    int[] digits = new int[4];
    int n = num;

    for (int i = 0; i < 4; i++) {
      digits[i] = n % 10;
      n /= 10;
    }

    Arrays.sort(digits);
    return (digits[0] * 10 + digits[2]) + (digits[1] * 10 + digits[3]);
  }
}

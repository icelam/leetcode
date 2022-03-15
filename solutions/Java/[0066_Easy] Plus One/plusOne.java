class Solution {
  public int[] plusOne(int[] digits) {
    int carry = 1;
    int i = digits.length - 1;

    while (i >= 0 && carry > 0) {
      int temp = digits[i] + carry;
      digits[i] = temp % 10;
      carry = temp / 10;
      i--;
    }

    if (carry == 0) {
      return digits;
    }

    int[] result = new int[digits.length + 1];
    result[0] = carry;
    return result;
  }
}

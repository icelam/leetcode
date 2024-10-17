class Solution {
  public int maximumSwap(int num) {
    char[] digits = Integer.toString(num).toCharArray();
    int n = digits.length;
    int maxIndex = digits.length - 1;
    int pointer1 = -1;
    int pointer2 = 0;

    for (int i = n - 2; i >= 0; i--) {
      if (digits[i] > digits[maxIndex]) {
        maxIndex = i;
        continue;
      }

      if (digits[i] < digits[maxIndex]) {
        pointer1 = i;
        pointer2 = maxIndex;
      }
    }

    if (pointer1 == -1) {
      return num;
    }

    char temp = digits[pointer1];
    digits[pointer1] = digits[pointer2];
    digits[pointer2] = temp;

    int result = 0;

    for (char c: digits) {
      result = result * 10 + (c - '0');
    }

    return result;
  }
}

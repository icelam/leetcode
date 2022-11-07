class Solution {
  public int getNumberOfDigits(int n) {
    if (n < 10) {
      return 1;
    } else if (n < 100) {
      return 2;
    } else if (n < 1000) {
      return 3;
    } else if (n < 10000) {
      return 4;
    }
    return 5;
  }

  public int maximum69Number(int num) {
    int numberOfDigits = getNumberOfDigits(num);
    for (int i = (int) Math.pow(10, numberOfDigits - 1); i >= 1; i /= 10) {
      if (num / i % 10 == 6) {
        num += 3 * i;
        break;
      }
    }
    return num;
  }
}

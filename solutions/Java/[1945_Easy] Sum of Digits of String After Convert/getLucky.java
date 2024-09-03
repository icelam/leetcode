class Solution {
  public int getLucky(String s, int k) {
    int num = 0;

    for (char c: s.toCharArray()) {
      int value = c - 'a' + 1;

      while (value > 0) {
        num += (value % 10);
        value /= 10;
      }
    }

    for (int i = k - 1; i > 0; i--) {
      int newNum = 0;

      while (num > 0) {
        newNum += (num % 10);
        num /= 10;
      }

      num = newNum;
    }

    return num;
  }
}

class Solution {
  public int addDigits(int num) {
    return 1 + ((num - 1) % (10 - 1));
  }
}

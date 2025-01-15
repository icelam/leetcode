class Solution {
  public int minimizeXor(int num1, int num2) {
    int bitCount1 = Integer.bitCount(num1);
    int bitCount2 = Integer.bitCount(num2);

    while (bitCount2 < bitCount1) {
      num1 &= num1 - 1;
      bitCount2++;
    }

    while (bitCount2 > bitCount1) {
      num1 |= num1 + 1;
      bitCount2--;
    }

    return num1;
  }
}

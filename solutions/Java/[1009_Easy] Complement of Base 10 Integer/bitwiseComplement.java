class Solution {
  public int bitwiseComplement(int n) {
    if (n == 0) {
      return 1;
    }

    int num = n;
    int bitLength = (int) (Math.log(num) / Math.log(2)) + 1;

    for (int i = 0; i < bitLength; i++) {
      num ^= 1 << i;
    }

    return num;
  }
}

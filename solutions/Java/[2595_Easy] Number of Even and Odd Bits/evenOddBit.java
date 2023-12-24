class Solution {
  public int[] evenOddBit(int n) {
    int[] result = new int[2];

    for (int i = 0; i < 32; i++) {
      result[i & 1] += (n >> i) & 1;
    }

    return result;
  }
}

class Solution {
  public int singleNumber(int[] nums) {
    int a = 0;
    int b = 0;

    for (int num: nums) {
      int c = (~a & b & num) | (a & ~b & ~num);
      int d = ~a & (b ^ num);
      a = c;
      b = d;
    }

    return b;
  }
}

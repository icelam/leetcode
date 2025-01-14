class Solution {
  public int[] findThePrefixCommonArray(int[] A, int[] B) {
    int n = A.length;
    int[] result = new int[n];
    long p = 0;
    long q = 0;

    for (int i = 0; i < n; ++i) {
      p |= 1L << A[i];
      q |= 1L << B[i];
      result[i] = Long.bitCount(p & q);
    }

    return result;
  }
}

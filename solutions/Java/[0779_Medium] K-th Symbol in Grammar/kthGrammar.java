class Solution {
  public int kthGrammar(int n, int k) {
    if (n == 1) {
      return 0;
    }

    int halfBitCount = (1 << (n - 1)) >> 1;

    if (k <= halfBitCount) {
      return (kthGrammar(n - 1, k));
    }

    return kthGrammar(n - 1, k - halfBitCount) ^ 1;
  }
}

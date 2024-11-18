class Solution {
  public int[] decrypt(int[] code, int k) {
    int n = code.length;
    int[] decryptedCode = new int[n];

    if (k == 0) {
      return decryptedCode;
    }

    int start = 1;
    int end = k;
    int sum = 0;

    if (k < 0) {
      start = n - Math.abs(k);
      end = n - 1;
    }

    for (int i = start; i <= end; i++) {
      sum += code[i];
    }

    for (int i = 0; i < n; i++) {
      decryptedCode[i] = sum;
      sum -= code[(start + i) % n];
      sum += code[(end + i + 1) % n];
    }

    return decryptedCode;
  }
}

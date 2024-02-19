class Solution {
  public int[] decode(int[] encoded, int first) {
    int m = encoded.length;
    int n = m + 1;
    int[] result = new int[n];
    result[0] = first;

    for (int i = 0; i < m; i++) {
      result[i + 1] = result[i] ^ encoded[i];
    }

    return result;
  }
}

class Solution {
  public int[] sumZero(int n) {
    int[] result = new int[n];

    for (int i = n - 1; i > 0; i -= 2) {
      result[i] = i;
      result[i - 1] = i * -1;
    }

    return result;
  }
}

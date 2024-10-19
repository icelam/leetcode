class Solution {
  public char findKthBit(int n, int k) {
    StringBuilder builder = new StringBuilder("0");

    for (int i = 1; i < n && k > builder.length(); i++) {
      builder.append(1);

      for (int j = builder.length() - 2; j >= 0; j--) {
        builder.append(((builder.charAt(j) - '0') + 1) % 2);
      }
    }

    return builder.charAt(k - 1);
  }
}

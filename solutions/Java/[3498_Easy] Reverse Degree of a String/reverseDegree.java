class Solution {
  public int reverseDegree(String s) {
    int n = s.length();
    char[] characters = s.toCharArray();
    int product = 0;

    for (int i = 0; i < n; i++) {
      product += (26 - (characters[i] - 'a')) * (i + 1);
    }

    return product;
  }
}

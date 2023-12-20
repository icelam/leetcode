class Solution {
  public String generateTheString(int n) {
    char[] result = new char[n];
    Arrays.fill(result, 'a');
    if (n % 2 == 0) {
      result[n - 1] = 'b';
    }
    return new String(result);
  }
}

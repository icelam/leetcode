class Solution {
  public int gcd(int m, int n) {
    if (n == 0) {
      return m;
    }

    return gcd(n, m % n);
  }

  public String gcdOfStrings(String str1, String str2) {
    int m = str1.length();
    int n = str2.length();
    int gcdOfLength = gcd(m, n);

    if (!(str1 + str2).equals(str2 + str1)) {
      return "";
    }

    return str1.substring(0, gcdOfLength);
  }
}

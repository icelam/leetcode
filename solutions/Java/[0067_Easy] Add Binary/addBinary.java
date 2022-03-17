class Solution {
  public String addBinary(String a, String b) {
    int i = a.length() - 1;
    int j = b.length() - 1;
    int carry = 0;

    StringBuilder result = new StringBuilder();

    while (i != -1 || j != -1 || carry != 0) {
      if (i >= 0) {
        carry += a.charAt(i) - '0';
        i--;
      }

      if (j >= 0) {
        carry += b.charAt(j) - '0';
        j--;
      }

      result.insert(0, carry % 2);
      carry = carry >= 2 ? 1 : 0;
    }

    return result.toString();
  }
}

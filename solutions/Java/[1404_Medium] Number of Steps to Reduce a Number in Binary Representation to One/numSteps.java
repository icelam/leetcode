class Solution {
  public int numSteps(String s) {
    int n = s.length();
    char[] bits = s.toCharArray();
    int operations = 0;
    int carry = 0;

    for (int i = n - 1; i > 0; i--) {
      int digit = (bits[i] - '0') + carry;

      if (digit % 2 == 1) {
        operations += 2;
        carry = 1;
      } else {
        operations++;
      }
    }

    return operations + carry;
  }
}

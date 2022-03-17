class Solution {
  public List<Integer> addToArrayForm(int[] num, int k) {
    LinkedList<Integer> result = new LinkedList<>();
    int i = num.length - 1;
    int carry = 0;

    while (i >= 0 || k > 0 || carry > 0) {
      carry += k % 10;

      if (i >= 0) {
        carry += num[i];
        i--;
      }

      result.addFirst(carry % 10);
      carry /= 10;
      k /= 10;
    }

    return result;
  }
}

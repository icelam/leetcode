class Solution {
  public void sumNodes(char[] num1, int index1, char[] num2, int index2, int carry, StringBuilder result) {
    if (index1 < 0 && index2 < 0 && carry == 0) {
      return;
    }

    int sum = carry;

    if (index1 >= 0) {
      sum += num1[index1] - '0';
    }

    if (index2 >= 0) {
      sum += num2[index2] - '0';
    }

    result.append(sum % 10);
    sumNodes(num1, index1 - 1, num2, index2 - 1, sum / 10, result);
  }

  public String addStrings(String num1, String num2) {
    StringBuilder result = new StringBuilder();
    sumNodes(num1.toCharArray(), num1.length() - 1, num2.toCharArray(), num2.length() - 1, 0, result);

    return result.reverse().toString();
  }
}

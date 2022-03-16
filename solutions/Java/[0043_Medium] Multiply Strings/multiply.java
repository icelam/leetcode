class Solution {
  public String numberArrayToString(int[] arr) {
    boolean isLeadingZero = true;
    StringBuilder output = new StringBuilder();

    for (int n: arr) {
      if (isLeadingZero && n == 0) {
        continue;
      }

      isLeadingZero = false;
      output.append(n);
    }

    return output.toString();
  }

  public String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0")) {
      return "0";
    }

    if (num1.equals("1")) {
      return num2;
    }

    if (num2.equals("1")) {
      return num1;
    }

    int[] result = new int[num1.length() + num2.length()];

    for (int i = num1.length() - 1; i >= 0; i--) {
      for (int j = num2.length() - 1; j >= 0; j--) {
        int digit1 = num1.charAt(i) - '0';
        int digit2 = num2.charAt(j) - '0';

        int product = digit1 * digit2;
        product += result[i + j + 1];
        result[i + j + 1] = product % 10;
        result[i + j] += product / 10;
      }
    }

    return numberArrayToString(result);
  }
}

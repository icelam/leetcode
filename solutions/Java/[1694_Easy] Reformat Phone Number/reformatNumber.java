class Solution {
  public String reformatNumber(String number) {
    StringBuilder digits = new StringBuilder();

    for (char c: number.toCharArray()) {
      if (Character.isDigit(c)) {
        digits.append(c);
      }
    }

    int n = digits.length();
    int i = 0;
    StringBuilder builder = new StringBuilder();

    while (n > 0) {
      if (n > 4) {
        builder.append(digits.substring(i, i + 3) + "-");
        i += 3;
        n -= 3;
      } else {
        if (n == 4) {
          builder.append(digits.substring(i, i + 2) + "-" + digits.substring(i + 2, i + 4));
        } else {
          builder.append(digits.substring(i, i + n));
        }
        break;
      }
    }

    return builder.toString();
  }
}

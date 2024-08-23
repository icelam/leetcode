class Solution {
  private int getGCD(int a, int b) {
    if (b == 0) {
      return a;
    }

    return getGCD(b, a % b);
  }

  public String fractionAddition(String expression) {
    int n = expression.length();
    char[] characters = expression.toCharArray();
    int sign = 1;
    int i = 0;
    int[] previousFraction = new int[2];
    previousFraction[1] = 1;

    while (i < n) {
      if (characters[i] == '+') {
        sign = 1;
        i++;
      } else if (characters[i] == '-') {
        sign = -1;
        i++;
      } else {
        int[] currentFraction = new int[2];

        while (i < n && Character.isDigit(characters[i])) {
          currentFraction[0] = currentFraction[0] * 10 + (characters[i] - '0');
          i++;
        }

        i++;

        while (i < n && Character.isDigit(characters[i])) {
          currentFraction[1] = currentFraction[1] * 10 + (characters[i] - '0');
          i++;
        }

        currentFraction[0] *= sign;
        previousFraction[0] = previousFraction[0] * currentFraction[1] + currentFraction[0] * previousFraction[1];
        previousFraction[1] *= currentFraction[1];
      }
    }

    int gcd = Math.abs(getGCD(previousFraction[0], previousFraction[1]));

    StringBuilder fraction = new StringBuilder();
    fraction.append(previousFraction[0] / gcd);
    fraction.append('/');
    fraction.append(previousFraction[1] / gcd);

    return fraction.toString();
  }
}

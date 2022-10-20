class Solution {
  private static final int[] DECIMIALS = {
    1000,
    900,
    500,
    400,
    100,
    90,
    50,
    40,
    10,
    9,
    5,
    4,
    1
  };

  private static final String[] ROMANS = {
    "M",
    "CM",
    "D",
    "CD",
    "C",
    "XC",
    "L",
    "XL",
    "X",
    "IX",
    "V",
    "IV",
    "I"
  };

  public String intToRoman(int num) {
    StringBuilder result = new StringBuilder();

    for (int i = 0; num > 0; i++) {
      while (num >= DECIMIALS[i]) {
        num -= DECIMIALS[i];
        result.append(ROMANS[i]);
      }
    }

    return result.toString();
  }
}

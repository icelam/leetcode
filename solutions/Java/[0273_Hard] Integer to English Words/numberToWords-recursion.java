class Solution {
  private static String[] baseNumbers = new String[] {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
  private static String[] multipleOfTenNumbers = new String[] {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
  private static String[] units = new String[] {"", "Thousand", "Million", "Billion"};

  public String numberToWords(int num) {
    if (num == 0) {
      return baseNumbers[0];
    }

    StringBuilder builder = new StringBuilder();
    int unitIndex = 0;

    while (num > 0) {
      int currentPart = num % 1000;

      if (currentPart > 0) {
        builder.insert(0, " ");
        builder.insert(0, units[unitIndex]);

        int hundredDigit = currentPart / 100;
        int remainingDigits = currentPart % 100;

        if (remainingDigits > 0 && remainingDigits < 20) {
          builder.insert(0, " ");
          builder.insert(0, baseNumbers[remainingDigits]);
        } else if (remainingDigits >= 20) {
          if (remainingDigits % 10 > 0) {
            builder.insert(0, " ");
            builder.insert(0, baseNumbers[remainingDigits % 10]);
          }

          builder.insert(0, " ");
          builder.insert(0, multipleOfTenNumbers[remainingDigits / 10]);
        }

        if (hundredDigit > 0) {
          builder.insert(0, " Hundred ");
          builder.insert(0, baseNumbers[hundredDigit]);
        }
      }

      unitIndex++;
      num /= 1000;
    }

    return builder.toString().trim();
  }
}

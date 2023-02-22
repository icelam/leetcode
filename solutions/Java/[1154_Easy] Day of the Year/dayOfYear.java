class Solution {
  public int convertToInt(char[] characters, int left, int right) {
    int n = 0;

    while (left <= right) {
      n = n * 10 + (characters[left] - '0');
      left++;
    }

    return n;
  }

  public boolean isLeapYear(int year) {
    return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
  }

  public int dayOfYear(String date) {
    int[] sumOfDays = new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};

    char[] characters = date.toCharArray();

    int year = convertToInt(characters, 0, 3);
    int month = convertToInt(characters, 5, 6);
    int day = convertToInt(characters, 8, 9);

    return sumOfDays[month - 1] + day + (isLeapYear(year) && month > 2 ? 1 : 0);
  }
}

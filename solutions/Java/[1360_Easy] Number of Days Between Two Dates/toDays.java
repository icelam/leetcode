class Solution {
  private static int[] daysInMonthSum = new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};

  private boolean isLeapYear(int year) {
    return (year % 400 == 0) || (year % 100 != 0 && year % 4 == 0);
  }

  private int toDays(String date) {
    String[] dateParts = date.split("-");
    int year = Integer.valueOf(dateParts[0]);
    int month = Integer.valueOf(dateParts[1]);
    int day = Integer.valueOf(dateParts[2]);
    int result = 0;

    result += daysInMonthSum[month - 1] + day;

    if (isLeapYear(year) && month > 2) {
      result++;
    }

    for (int i = year - 1; i >= 1971; i--) {
      result += daysInMonthSum[12];

      if (isLeapYear(i)) {
        result++;
      }
    }

    return result;
  }

  public int daysBetweenDates(String date1, String date2) {
    return Math.abs(toDays(date1) - toDays(date2));
  }
}

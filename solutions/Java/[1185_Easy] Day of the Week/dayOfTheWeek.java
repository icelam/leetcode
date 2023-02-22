class Solution {
  private static String[] weekdayName = new String[]{
    "Sunday",
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday"
  };

  public String dayOfTheWeek(int day, int month, int year) {
    // Zeller’s Congruence Algorithm
    if (month < 3) {
      month += 12;
      year--;
    }

    int c = year / 100;
    year = year % 100;
    int h = (c / 4 - 2 * c + year + year / 4 + 13 * (month + 1) / 5 + day - 1) % 7;

    return weekdayName[(h + 7) % 7];
  }
}

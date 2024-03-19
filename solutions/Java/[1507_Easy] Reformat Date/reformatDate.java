class Solution {
  private static HashMap<String, Integer> monthMap = new HashMap<>() {{
    put("Jan", 1);
    put("Feb", 2);
    put("Mar", 3);
    put("Apr", 4);
    put("May", 5);
    put("Jun", 6);
    put("Jul", 7);
    put("Aug", 8);
    put("Sep", 9);
    put("Oct", 10);
    put("Nov", 11);
    put("Dec", 12);
  }};

  public String reformatDate(String date) {
    int n = date.length();
    char[] characters = date.toCharArray();
    int[] spacePosition = new int[2];
    StringBuilder result = new StringBuilder();

    for (int i = 0, j = 0; i < n; i++) {
      if (characters[i] == ' ') {
        spacePosition[j] = i;
        j++;
      }
    }

    for (int i = spacePosition[1] + 1; i < n; i++) {
      result.append(characters[i]);
    }

    result.append('-');

    char[] monthChars = new char[3];

    for (int i = 0; i < 3; i++) {
      monthChars[i] = characters[i + spacePosition[0] + 1];
    }

    int month = monthMap.get(new String(monthChars));

    if (month < 10) {
      result.append('0');
    }

    result.append(month);
    result.append('-');

    int day = 0;

    for (int i = 0; i < spacePosition[0] && Character.isDigit(characters[i]); i++) {
      day = day * 10 + (characters[i] - '0');
    }

    if (day < 10) {
      result.append('0');
    }

    result.append(day);

    return result.toString();
  }
}

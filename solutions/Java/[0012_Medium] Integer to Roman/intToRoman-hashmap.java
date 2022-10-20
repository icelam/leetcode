class Solution {
  private static final Map<Integer, String> ROMANS_MAP = getRomanMap();

  private static Map<Integer, String> getRomanMap() {
    HashMap<Integer, String> map = new HashMap<>();
    map.put(1, "I");
    map.put(2, "II");
    map.put(3, "III");
    map.put(4, "IV");
    map.put(5, "V");
    map.put(6, "VI");
    map.put(7, "VII");
    map.put(8, "VIII");
    map.put(9, "IX");
    map.put(10, "X");
    map.put(20, "XX");
    map.put(30, "XXX");
    map.put(40, "XL");
    map.put(50, "L");
    map.put(60, "LX");
    map.put(70, "LXX");
    map.put(80, "LXXX");
    map.put(90, "XC");
    map.put(100, "C");
    map.put(200, "CC");
    map.put(300, "CCC");
    map.put(400, "CD");
    map.put(500, "D");
    map.put(600, "DC");
    map.put(700, "DCC");
    map.put(800, "DCCC");
    map.put(900, "CM");
    map.put(1000, "M");
    map.put(2000, "MM");
    map.put(3000, "MMM");
    return Collections.unmodifiableMap(map);
  }

  public String intToRoman(int num) {
    StringBuilder result = new StringBuilder();
    int multiplier = 1;

    while (num > 0) {
      int digit = num % 10;

      if (digit > 0) {
        result.insert(0, ROMANS_MAP.get(digit * multiplier));
      }

      multiplier *= 10;
      num /= 10;
    }

    return result.toString();
  }
}

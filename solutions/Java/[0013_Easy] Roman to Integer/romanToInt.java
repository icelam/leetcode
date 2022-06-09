class Solution {
  public int romanToInt(String s) {
    HashMap<Character, Integer> map = new HashMap<>() {{
      put('I', 1);
      put('V', 5);
      put('X', 10);
      put('L', 50);
      put('C', 100);
      put('D', 500);
      put('M', 1000);
    }};

    char[] c = s.toCharArray();
    int result = map.get(c[0]);

    for (int i = 1; i < c.length; i++) {
      result += map.get(c[i]);

      if (
        (c[i - 1] == 'I' && (c[i] == 'V' || c[i] == 'X'))
        || (c[i - 1] == 'X' && (c[i] == 'L' || c[i] == 'C'))
        || (c[i - 1] == 'C' && (c[i] == 'D' || c[i] == 'M'))
      ) {
        result -= (map.get(c[i - 1]) * 2);
      }
    }

    return result;
  }
}

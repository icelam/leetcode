class Solution {
  private String count(String s) {
    StringBuilder result = new StringBuilder();

    int length = s.length();
    int start = 0;
    int end = 0;

    while (end < length) {
      while (end < length && s.charAt(end) == s.charAt(start)) {
        end++;
      }

      result.append(end - start);
      result.append(s.charAt(start));
      start = end;
    }

    return result.toString();
  }

  public String countAndSay(int n) {
    String result = "1";

    while (n > 1) {
      result = count(result);
      n--;
    }

    return result;
  }
}

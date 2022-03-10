class Solution {
  public String toLowerCase(String s) {
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      int charCode = s.charAt(i);
      if (charCode >= 65 && charCode <= 90) {
        result.append((char) (charCode + 32));
      } else {
        result.append(s.charAt(i));
      }
    }

    return result.toString();
  }
}

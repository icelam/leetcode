class Solution {
  public String evaluateString(String s) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != '#') {
        result.append(s.charAt(i));
      } else if (result.length() > 0) {
        result.deleteCharAt(result.length() - 1);
      }
    }

    return result.toString();
  }

  public boolean backspaceCompare(String s, String t) {
    return evaluateString(s).equals(evaluateString(t));
  }
}

class Solution {
  public String defangIPaddr(String address) {
    int length = address.length();
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < length; i++) {
      char c = address.charAt(i);
      if (c == '.') {
        result.append("[.]");
      } else {
        result.append(c);
      }
    }

    return result.toString();
  }
}

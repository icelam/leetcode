class Solution {
  public String finalString(String s) {
    StringBuilder builder = new StringBuilder();

    for (char c: s.toCharArray()) {
      if (c == 'i') {
        builder.reverse();
        continue;
      }

      builder.append(c);
    }

    return builder.toString();
  }
}

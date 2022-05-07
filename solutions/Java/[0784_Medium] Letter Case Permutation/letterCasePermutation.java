class Solution {
  public boolean isNumber(char c) {
    return c >= '0' && c <= '9';
  }

  public boolean isLowerCase(char c) {
    return c >= 'a' && c <= 'z';
  }

  public char toUpperCase(char c) {
    return (char) (c - 'a' + 'A');
  }

  public char toLowerCase(char c) {
    return (char) (c - 'A' + 'a');
  }

  public void generate(List<String> result, char[] c, int i) {
    if (i == c.length) {
      result.add(new String(c));
      return;
    }

    generate(result, c, i + 1);

    if (!isNumber(c[i])) {
      char temp = c[i];
      c[i] = isLowerCase(c[i]) ? toUpperCase(c[i]) : toLowerCase(c[i]);
      generate(result, c, i + 1);
      c[i] = temp;
    }
  }

  public List<String> letterCasePermutation(String s) {
    List<String> result = new ArrayList();
    generate(result, s.toCharArray(), 0);
    return result;
  }
}

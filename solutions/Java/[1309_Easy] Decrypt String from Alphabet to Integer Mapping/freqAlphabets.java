class Solution {
  public char toAlphabet(String s) {
    return (char) (Integer.parseInt(s) + 96);
  }

  public String freqAlphabets(String s) {
    StringBuilder result = new StringBuilder();

    int i = 0;
    while (i < s.length()) {
      if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
        result.append(toAlphabet(s.substring(i, i + 2)));
        i += 3;
      } else {
        result.append(toAlphabet(s.substring(i, i + 1)));
        i++;
      }
    }

    return result.toString();
  }
}

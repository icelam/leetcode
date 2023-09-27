class Solution {
  public boolean isLetter(char c) {
    return Character.isLetter(c);
  }

  public int toNumber(char c) {
    return c - '0';
  }

  public String decodeAtIndex(String s, int k) {
    char[] characters = s.toCharArray();
    int n = characters.length;
    long length = 0;

    for (char c: characters) {
      if (isLetter(c)) {
        length++;
      } else {
        length *= toNumber(c);
      }
    }

    int index = n - 1;

    while (index >= 0) {
      char c = characters[index];
      k %= length;

      if (k == 0 && isLetter(c)) {
        return Character.toString(characters[index]);
      }

      if (isLetter(c)) {
        length--;
      } else {
        length /= toNumber(c);
      }

      index--;
    }

    return "";
  }
}

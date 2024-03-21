class Solution {
  public int countTime(String time) {
    char[] characters = time.toCharArray();
    int result = 1;

    if (characters[0] == '?' && characters[1] == '?') {
      result = 24;
    } else if (characters[0] == '?') {
      result = characters[1] - '0' <= 3 ? 3 : 2;
    } else if (characters[1] == '?') {
      result = characters[0] - '0' == 2 ? 4 : 10;
    }

    if (characters[3] == '?') {
      result *= 6;
    }

    if (characters[4] == '?') {
      result *= 10;
    }

    return result;
  }
}

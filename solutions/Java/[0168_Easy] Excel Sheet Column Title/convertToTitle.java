class Solution {
  public char toColumnChar(int code) {
    return (char) ((code == 0 ? 26 : code) + 64);
  }

  public String convertToTitle(int columnNumber) {
    int remain = columnNumber;
    StringBuilder result = new StringBuilder();

    while (remain > 0) {
      if (remain % 26 == 0) {
        result.append(toColumnChar(26));
        remain = remain / 26 - 1;
      } else {
        result.append(toColumnChar(remain % 26));
        remain = remain / 26;
      }
    }

    return result.reverse().toString();
  }
}

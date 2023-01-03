class Solution {
  public int minDeletionSize(String[] strs) {
    int height = strs.length;
    int width = strs[0].length();
    int result = 0;

    for (int column = 0; column < width; column++) {
      char previousChar = 'a';

      for (int row = 0; row < height; row++) {
        char currentChar = strs[row].charAt(column);

        if (currentChar < previousChar) {
          result++;
          break;
        }

        previousChar = currentChar;
      }
    }

    return result;
  }
}

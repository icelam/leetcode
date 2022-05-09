class Solution {
  public void generate(char[] digits, char[] chars, int position, char[][] map, List<String> result) {
    if (position == digits.length) {
      result.add(new String(chars));
      return;
    }

    char temp = chars[position];

    for (char c: map[digits[position] - 50]) {
      chars[position] = c;
      generate(digits, chars, position + 1, map, result);
    }

    chars[position] = temp;
  }

  public List<String> letterCombinations(String digits) {
    char[][] map = new char[][]{
      {'a', 'b', 'c'},
      {'d', 'e', 'f'},
      {'g', 'h', 'i'},
      {'j', 'k', 'l'},
      {'m', 'n', 'o'},
      {'p', 'q', 'r', 's'},
      {'t', 'u', 'v'},
      {'w', 'x', 'y', 'z'}
    };

    LinkedList<String> result = new LinkedList<>();

    if (digits.length() > 0) {
      generate(digits.toCharArray(), new char[digits.length()], 0, map, result);
    }

    return result;
  }
}

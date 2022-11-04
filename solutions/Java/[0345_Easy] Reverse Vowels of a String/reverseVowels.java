class Solution {
  private boolean isVowels(char c) {
    return (
      c == 'a'
      || c == 'e'
      || c == 'i'
      || c == 'o'
      || c == 'u'
      || c == 'A'
      || c == 'E'
      || c == 'I'
      || c == 'O'
      || c == 'U'
    );
  }

  public String reverseVowels(String s) {
    char[] characters = s.toCharArray();

    int left = 0;
    int right = characters.length - 1;

    while (left < right) {
      while (left < right && !isVowels(characters[left])) {
        left++;
      }

      while (left < right && !isVowels(characters[right])) {
        right--;
      }

      if (left >= right) {
        break;
      }

      char temp = characters[left];
      characters[left] = characters[right];
      characters[right] = temp;
      left++;
      right--;
    }

    return new String(characters);
  }
}

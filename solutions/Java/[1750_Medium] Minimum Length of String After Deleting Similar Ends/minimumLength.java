class Solution {
  public int minimumLength(String s) {
    char[] characters = s.toCharArray();
    int n = characters.length;

    int left = 0;
    int right = n - 1;

    while (left < right && characters[left] == characters[right]) {
      char c = characters[left];

      while (left <= right && characters[left] == c) {
        left++;
      }

      while (right >= left && characters[right] == c) {
        right--;
      }
    }

    return right - left + 1;
  }
}

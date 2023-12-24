class Solution {
  public String reverseOnlyLetters(String s) {
    char[] characters = s.toCharArray();
    int n = characters.length;
    int m = 0;
    int[] letterIndices = new int[n];

    for (int i = 0; i < n; i++) {
      if (Character.isLetter(characters[i])) {
        letterIndices[m] = i;
        m++;
      }
    }

    int left = 0;
    int right = m - 1;

    while (left < right) {
      char temp = characters[letterIndices[left]];
      characters[letterIndices[left]] = characters[letterIndices[right]];
      characters[letterIndices[right]] = temp;
      left++;
      right--;
    }

    return new String(characters);
  }
}

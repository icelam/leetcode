class Solution {
  private char binarySearch(char[] arr, char target) {
    int start = 0;
    int end = arr.length - 1;
    int middle = 0;

    while (start <= end) {
      middle = start + ((end - start) / 2);
      char val = arr[middle];

      if (val <= target) {
        start = middle + 1;
      } else {
        end = middle - 1;
      }
    }

    // If there are no characters in letters that is lexicographically greater than `target`,
    // return the first `letters[0]`
    if (start == arr.length) {
      return arr[0];
    }

    return arr[start];
  }

  public char nextGreatestLetter(char[] letters, char target) {
    return binarySearch(letters, target);
  }
}

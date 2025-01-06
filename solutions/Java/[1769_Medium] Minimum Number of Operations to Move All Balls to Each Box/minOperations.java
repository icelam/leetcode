class Solution {
  public int[] minOperations(String boxes) {
    int n = boxes.length();
    char[] boxChar = boxes.toCharArray();
    int left = boxChar[0] - '0';
    int right = 0;
    int operations = 0;

    for (int i = 1; i < n; i++) {
      if (boxChar[i] == '1') {
        right++;
        operations += i;
      }
    }

    int[] result = new int[n];
    result[0] = operations;

    for (int i = 1; i < n; i++) {
      operations += left - right;

      if (boxChar[i] == '1') {
        left++;
        right--;
      }

      result[i] = operations;
    }

    return result;
  }
}

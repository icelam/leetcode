class Solution {
  public int minCost(String colors, int[] neededTime) {
    int result = 0;

    int index = 0;
    char[] c = colors.toCharArray();
    int length = c.length;

    while (index < length) {
      int max = 0;
      int sum = 0;
      char currentColor = c[index];

      while (index < length && c[index] == currentColor) {
        sum += neededTime[index];
        max = Math.max(max, neededTime[index]);
        index++;
      }

      result += sum - max;
    }

    return result;
  }
}

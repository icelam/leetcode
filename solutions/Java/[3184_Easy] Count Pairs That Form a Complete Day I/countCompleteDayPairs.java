class Solution {
  public int countCompleteDayPairs(int[] hours) {
    int[] count = new int[24];
    int result = 0;

    for (int times : hours) {
      result += count[(24 - times % 24) % 24];
      count[times % 24]++;
    }

    return result;
  }
}

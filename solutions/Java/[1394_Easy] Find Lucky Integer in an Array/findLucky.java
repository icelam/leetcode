class Solution {
  public int findLucky(int[] arr) {
    int[] frequency = new int[501];

    for (int value: arr) {
      frequency[value]++;
    }

    for (int i = 500; i >= 1; i--) {
      if (frequency[i] == i) {
        return frequency[i];
      }
    }

    return -1;
  }
}

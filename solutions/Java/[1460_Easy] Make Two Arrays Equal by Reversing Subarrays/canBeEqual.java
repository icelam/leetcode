class Solution {
  public boolean canBeEqual(int[] target, int[] arr) {
    int[] frequency = new int[1001];

    for (int value: target) {
      frequency[value]++;
    }

    for (int value: arr) {
      frequency[value]--;
    }

    for (int count: frequency) {
      if (count != 0) {
        return false;
      }
    }

    return true;
  }
}

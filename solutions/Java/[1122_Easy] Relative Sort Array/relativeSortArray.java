class Solution {
  public int[] relativeSortArray(int[] arr1, int[] arr2) {
    int n = arr1.length;
    int[] frequency = new int[1001];
    int[] result = new int[n];
    int pointer = 0;

    for (int i = 0; i < n; i++) {
      frequency[arr1[i]]++;
    }

    for (int currentItem: arr2) {
      while (frequency[currentItem] > 0) {
        result[pointer] = currentItem;
        pointer++;
        frequency[currentItem]--;
      }
    }

    for (int num = 0; num < 1001; num++) {
      while (frequency[num] > 0) {
        result[pointer] = num;
        pointer++;
        frequency[num]--;
      }
    }

    return result;
  }
}

class Solution {
  public void insertionSort(int[][] arr) {
    for (int k = 1; k < arr.length; k++) {
      int[] key = arr[k];
      int i = k - 1;
      while (i >= 0 && (arr[i][0] > key[0] || (arr[i][0] == key[0] && arr[i][1] < key[1]))) {
        arr[i + 1] = arr[i];
        i--;
      }
      arr[i + 1] = key;
    }
  }

  public int removeCoveredIntervals(int[][] intervals) {
    insertionSort(intervals);

    int count = 1;
    int rangeMax = intervals[0][1];

    for (int[] i: intervals) {
      if (rangeMax < i[1]) {
        count++;
        rangeMax = i[1];
      }
    }

    return count;
  }
}

class Solution {
  int partition(int[][] arr, int low, int high) {
    int pivot = arr[(high + low) / 2][0];
    int i = low;
    int j = high;

    while (i <= j) {
      while (arr[i][0] < pivot) {
        i++;
      }

      while (arr[j][0] > pivot) {
        j--;
      }

      if (i <= j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
      }
    }

    return i;
  }

  void quickSort(int[][] arr, int low, int high) {
    if (arr.length > 1) {
      int middle = partition(arr, low, high);

      if (low < middle - 1) {
        quickSort(arr, low, middle - 1);
      }

      if (middle < high) {
        quickSort(arr, middle, high);
      }
    }
  }

  public int[][] merge(int[][] intervals) {
    quickSort(intervals, 0, intervals.length - 1);

    int min = intervals[0][0];
    int max = intervals[0][1];

    List<int[]> result = new ArrayList<>();

    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] <= max) {
        min = Math.min(min, intervals[i][0]);
        max = Math.max(max, intervals[i][1]);
      } else {
        result.add(new int[]{min, max});
        min = intervals[i][0];
        max = intervals[i][1];
      }
    }

    result.add(new int[]{min, max});

    return result.toArray(new int[result.size()][]);
  }
}

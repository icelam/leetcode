class Solution {
  int partition(int[] arr, int low, int high) {
    int pivot = arr[(high + low) / 2];
    int i = low;
    int j = high;

    while (i <= j) {
      while (arr[i] < pivot) {
        i++;
      }

      while (arr[j] > pivot) {
        j--;
      }

      if (i <= j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
      }
    }

    return i;
  }

  void quickSort(int[] arr, int low, int high) {
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

  public List<List<Integer>> minimumAbsDifference(int[] arr) {
    quickSort(arr, 0, arr.length - 1);

    int minDifference = Integer.MAX_VALUE;
    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < arr.length - 1; i++) {
      boolean isNewMinDifference = arr[i + 1] - arr[i] < minDifference;
      boolean isEqualToMinDifference = arr[i + 1] - arr[i] == minDifference;

      if (isNewMinDifference) {
        minDifference = arr[i + 1] - arr[i];
        result.clear();
      }

      if (isEqualToMinDifference || isNewMinDifference) {
        List<Integer> pair = new ArrayList<>();
        pair.add(arr[i]);
        pair.add(arr[i + 1]);

        result.add(pair);
      }
    }

    return result;
  }
}

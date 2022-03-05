class Solution {
  int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = (low - 1);

    for (int j = low; j < high; j++) {
      if (arr[j] < pivot) {
        i++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    return (i + 1);
  }

  void quickSort(int[] arr, int low, int high) {
    if (low < high) {
      int center = partition(arr, low, high);

      quickSort(arr, low, center - 1);
      quickSort(arr, center + 1, high);
    }
  }

  public boolean canMakeArithmeticProgression(int[] arr) {
    quickSort(arr, 0, arr.length - 1);

    int difference = arr[1] - arr[0];

    for (int i = 1; i < arr.length - 1; i++) {
      if (arr[i + 1] - arr[i] != difference) {
        return false;
      }
    }

    return true;
  }
}

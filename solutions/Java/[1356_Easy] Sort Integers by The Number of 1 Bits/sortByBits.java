class Solution {
  public static int countBits(int n) {
    int count = 0;

    while (n != 0) {
      count += n & 1;
      n >>= 1;
    }

    return count;
  }

  int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = (low - 1);

    for (int j = low; j < high; j++) {
      if (
        countBits(arr[j]) < countBits(pivot)
        || (countBits(arr[j]) == countBits(pivot) && arr[j] < pivot)
      ) {
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

  public int[] sortByBits(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
    return arr;
  }
}

class Solution {
  public int[] copySubArray(int[] arr, int left, int right) {
    int size = right - left + 1;
    int[] temp = new int[size];

    for (int i = 0; i < size; i++) {
      temp[i] = arr[left + i];
    }

    return temp;
  }

  private int partition(int[] arr, int low, int high) {
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

  private void quickSort(int[] arr, int low, int high) {
    if (low < high) {
      int center = partition(arr, low, high);

      quickSort(arr, low, center - 1);
      quickSort(arr, center + 1, high);
    }
  }

  public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
    List<Boolean> result = new ArrayList<>();

    for (int i = 0; i < l.length; i++) {
      int[] temp = copySubArray(nums, l[i], r[i]);
      quickSort(temp, 0, temp.length - 1);

      int difference = temp[1] - temp[0];
      boolean isArithmeticSequence = true;

      for (int j = 2; j < temp.length; j++) {
        if (temp[j] - temp[j - 1] != difference) {
          isArithmeticSequence = false;
          break;
        }
      }

      result.add(isArithmeticSequence);
    }

    return result;
  }
}

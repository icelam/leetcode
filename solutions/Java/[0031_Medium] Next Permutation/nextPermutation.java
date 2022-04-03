class Solution {
  public int partition(int[] arr, int low, int high) {
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

  public void quickSort(int[] arr, int low, int high) {
    if (low < high) {
      int center = partition(arr, low, high);

      quickSort(arr, low, center - 1);
      quickSort(arr, center + 1, high);
    }
  }

  public void nextPermutation(int[] nums) {
    int length = nums.length;
    // The first index from the end which it's digit is smaller that it's right
    int i = length - 1;

    for (; i >= 1; i--) {
      if (nums[i] > nums[i - 1]) {
        break;
      }
    }

    if (i > 0) {
      // Find the first digit from right which is greater than the first smaller digit (nums[i])
      for (int j = length - 1; j >= i; j--) {
        if (nums[j] > nums[i - 1]) {
          int temp = nums[j];
          nums[j] = nums[i - 1];
          nums[i - 1] = temp;
          break;
        }
      }
    }

    quickSort(nums, i, length - 1);
  }
}

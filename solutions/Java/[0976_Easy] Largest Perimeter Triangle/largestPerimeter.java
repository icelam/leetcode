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

  void sort(int[] arr, int low, int high) {
    if (low < high) {
      int center = partition(arr, low, high);

      sort(arr, low, center - 1);
      sort(arr, center + 1, high);
    }
  }

  public int largestPerimeter(int[] nums) {
    sort(nums, 0, nums.length - 1);

    for (int i = nums.length - 3; i >= 0; --i) {
      if (nums[i] + nums[i + 1] > nums[i + 2]) {
        return nums[i] + nums[i + 1] + nums[i + 2];
      }
    }

    return 0;
  }
}

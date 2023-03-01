class MergeSort {
  public void sort(int[] arr) {
    mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
  }

  private void mergeSort(int[] arr, int left, int right, int[] tempArr) {
    if (left >= right) {
      return;
    }

    int center = (left + right) / 2;
    mergeSort(arr, left, center, tempArr);
    mergeSort(arr, center + 1, right, tempArr);
    merge(arr, left, center, right, tempArr);
  }

  private void merge(int[] arr, int low, int middle, int high, int[] tempArr) {
    int l = low;
    int i = low;
    int j = middle + 1;

    while (l <= middle && j <= high) {
      if (arr[l] <= arr[j]) {
        tempArr[i] = arr[l];
        l++;
      } else {
        tempArr[i] = arr[j];
        j++;
      }
      i++;
    }

    if (l > middle) {
      for (int k = j; k <= high; k++) {
        tempArr[i] = arr[k];
        i++;
      }
    } else {
      for (int k = l; k <= middle; k++) {
        tempArr[i] = arr[k];
        i++;
      }
    }

    for (int k = low; k <= high; k++) {
      arr[k] = tempArr[k];
    }
  }
}

class Solution {
  public int[] sortArray(int[] nums) {
    MergeSort sorter = new MergeSort();
    sorter.sort(nums);
    return nums;
  }
}

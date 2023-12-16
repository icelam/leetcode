class Solution {
  private int lowerBoundarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left < right) {
      int middle = left + (right - left) / 2;

      if (arr[middle] >= target) {
        right = middle;
      } else {
        left = middle + 1;
      }
    }

    if (arr[left] == target) {
      return left;
    }

    return -1;
  }

  private int upperBoundarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left < right) {
      int middle = 1 + left + (right - left) / 2;

      if (target >= arr[middle]) {
        left = middle;
      } else {
        right = middle - 1;
      }
    }

    if (arr[right] == target) {
      return right;
    }

    return -1;
  }

  public List<Integer> targetIndices(int[] nums, int target) {
    Arrays.sort(nums);

    List<Integer> result = new ArrayList<>();
    int left = lowerBoundarySearch(nums, target);

    if (left != -1) {
      int right = upperBoundarySearch(nums, target);

      for (int i = left; i <= right; i++) {
        result.add(i);
      }
    }

    return result;
  }
}

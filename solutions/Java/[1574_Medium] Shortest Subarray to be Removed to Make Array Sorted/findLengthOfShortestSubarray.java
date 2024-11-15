class Solution {
  public int findLengthOfShortestSubarray(int[] arr) {
  int n = arr.length;
  int right = n - 1;

  while (right > 0 && arr[right - 1] <= arr[right]) {
    right--;
  }

  if (right == 0) {
    return 0;
  }

  int result = right;

  for (int left = 0; left == 0 || arr[left - 1] <= arr[left]; ++left) {
    while (right < n && arr[right] < arr[left]) {
      right++;
    }

    result = Math.min(result, right - left - 1);
    }

    return result;
  }
}

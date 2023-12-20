class Solution {
  public boolean checkIfExist(int[] arr) {
    int n = arr.length;
    Arrays.sort(arr);

    for (int i = 0, j = 1; i < n; i++) {
      while (j < n - 1 && arr[i] * 2 > arr[j]) {
        j++;
      }

      if (i != j && arr[i] * 2 == arr[j]) {
        return true;
      }
    }

    for (int i = n - 2, j = n - 1; i >= 0; i--) {
      while (j > 0 && arr[i] * 2 < arr[j]) {
        j--;
      }

      if (i != j && arr[i] * 2 == arr[j]) {
        return true;
      }
    }

    return false;
  }
}

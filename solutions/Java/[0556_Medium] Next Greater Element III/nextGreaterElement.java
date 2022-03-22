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

  public int nextGreaterElement(int n) {
    if (n < 11) {
      return -1;
    }

    int length = (int) (Math.log10(n) + 1);
    int[] digits = new int[length];

    for (int i = length - 1; i >= 0; i--) {
      digits[i] = n % 10;
      n /= 10;
    }

    // The first index from the end which it's digit is smaller that it's right
    int i = length - 1;

    for (; i >= 1; i--) {
      if (digits[i] > digits[i - 1]) {
        break;
      }
    }

    if (i == 0) {
      return -1;
    }

    // Find the first digit from right which is greater than the first smaller digit (digits[i])
    for (int j = length - 1; j >= i; j--) {
      if (digits[j] > digits[i - 1]) {
        int temp = digits[j];
        digits[j] = digits[i - 1];
        digits[i - 1] = temp;
        break;
      }
    }

    quickSort(digits, i, length - 1);

    long result = 0;

    for (int k = length - 1, l = 0; k >= 0; k--, l++) {
      result += digits[k] * Math.pow(10, l);
    }

    return result > Integer.MAX_VALUE ? -1 : (int) result;
  }
}

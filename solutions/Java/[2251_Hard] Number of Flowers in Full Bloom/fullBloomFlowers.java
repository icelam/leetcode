class Solution {
  private int binarySearch(int[] arr, int target) {
    int index = arr.length;
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
      int middle = left + (right - left) / 2;

      if (arr[middle] >= target) {
        index = middle;
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }
    return index;
  }

  public int[] fullBloomFlowers(int[][] flowers, int[] people) {
    int m = people.length;
    int n = flowers.length;
    int[] result = new int[m];
    int[] starts = new int[n];
    int[] ends = new int[n];

    for (int i = 0; i < n; i++) {
      starts[i] = flowers[i][0];
      ends[i] = flowers[i][1];
    }

    Arrays.sort(starts);
    Arrays.sort(ends);

    for (int i = 0; i < m; i++) {
      result[i] = binarySearch(starts, people[i] + 1) - binarySearch(ends, people[i]);
    }

    return result;
  }
}

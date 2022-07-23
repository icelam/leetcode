class Solution {
  private List<Integer> toList(int[] arr) {
    ArrayList<Integer> list = new ArrayList<Integer>();

    for (int n: arr) {
      list.add(n);
    }

    return list;
  }

  private int binarySearch(List<Integer> arr, int target) {
    int start = 0;
    int end = arr.size() - 1;
    int middle = 0;

    while (start <= end) {
      middle = start + ((end - start) / 2);
      int val = arr.get(middle);

      if (val < target) {
        start = middle + 1;
      } else {
        end = middle - 1;
      }
    }

    if (arr.get(start) == target) {
      return start;
    }

    return middle;
  }

  public List<Integer> countSmaller(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    List<Integer> sortedNums = toList(nums);

    Collections.sort(sortedNums);

    for (int i = 0; i < n; i++) {
      int index = binarySearch(sortedNums, nums[i]);
      result[i] = index;
      sortedNums.remove(index);
    }

    return toList(result);
  }
}

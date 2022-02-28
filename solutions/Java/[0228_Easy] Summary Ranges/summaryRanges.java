class Solution {
  public List<String> summaryRanges(int[] nums) {
    List<String> result = new ArrayList<>();

    if (nums.length == 0) {
      return result;
    }

    int start = nums[0];
    int end = nums[0];

    for (int i = 0; i < nums.length; i++) {
      if (i < nums.length && i != 0 && nums[i] - 1 != nums[i - 1]) {
        result.add(formatResultString(start, end));
        start = nums[i];
      }

      end = nums[i];
    }

    result.add(formatResultString(start, end));

    return result;
  }

  public String formatResultString(int start, int end) {
    StringBuilder str = new StringBuilder();
    str.append(start);

    if (start != end) {
      str.append("->");
      str.append(end);
    }

    return str.toString();
  }
}

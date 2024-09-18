class Solution {
  public String largestNumber(int[] nums) {
    int n = nums.length;
    String[] stringifiedNums = new String[n];
    for (int i = 0; i < n; i++) {
      stringifiedNums[i] = Integer.toString(nums[i]);
    }

    Arrays.sort(stringifiedNums, (a, b) -> (b + a).compareTo(a + b));

    if (stringifiedNums[0].equals("0")) {
      return "0";
    }

    StringBuilder result = new StringBuilder();

    for (String value : stringifiedNums) {
      result.append(value);
    }

    return result.toString();
  }
}

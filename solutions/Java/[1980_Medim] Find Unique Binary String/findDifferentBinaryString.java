class Solution {
  public String findDifferentBinaryString(String[] nums) {
    Arrays.sort(nums);

    int n = nums.length;
    int missingNum = 0;

    while (missingNum < n && Integer.parseInt(nums[missingNum], 2) == missingNum) {
      missingNum++;
    }

    String missingBinary = Integer.toBinaryString(missingNum);
    StringBuilder builder = new StringBuilder();

    int zeroPadLength = n - missingBinary.length();

    while (zeroPadLength > 0) {
      builder.append('0');
      zeroPadLength--;
    }

    builder.append(missingBinary);

    return builder.toString();
  }
}

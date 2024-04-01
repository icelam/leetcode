class Solution {
  public int[] decompressRLElist(int[] nums) {
    int n = nums.length;
    int decodedLength = 0;

    for (int i = 0; i < n; i += 2) {
      decodedLength += nums[i];
    }

    int[] result = new int[decodedLength];
    int pointer = 0;

    for (int i = 0; i < n; i += 2) {
      for (int k = nums[i]; k > 0; k--) {
        result[pointer] = nums[i + 1];
        pointer++;
      }
    }

    return result;
  }
}

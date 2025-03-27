class Solution {
  public int minimumIndex(List<Integer> nums) {
    // Boyer-Moore Majority Voting Algorithm
    int n = nums.size();
    int dominantElement = nums.get(0);
    int count = 0;
    int dominantElementCount = 0;

    for (int value: nums) {
      count += value == dominantElement ? 1 : -1;

      if (count == 0) {
        dominantElement = value;
        count = 1;
      }
    }

    for (int value: nums) {
      dominantElementCount += value == dominantElement ? 1 : 0;
    }

    count = 0;

    for (int i = 0; i < n; i++) {
      if (nums.get(i) == dominantElement) {
        count++;
      }

      if (count * 2 > i + 1 && (dominantElementCount - count) * 2 > n - i - 1) {
        return i;
      }
    }

    return -1;
  }
}

class Solution {
  public boolean isPossible(int[] nums) {
    int MIN_LENGTH = 3;
    int MIN_VALUE = -1000;
    int MAX_VALUE = 1000;

    if (nums.length < MIN_LENGTH) {
      return false;
    }

    int rangeLength = MAX_VALUE - MIN_VALUE + 1;
    // Assign extra space to handle MAX_VALUE + 1 and MAX_VALUE + 2
    int memoLength = rangeLength + (MIN_LENGTH - 1);
    int offset = Math.abs(MIN_VALUE);

    // Number of appearance for each number
    int[] count = new int[memoLength];
    // Number of valid subsequences ends with `n`
    int[] end = new int[memoLength];

    for (int n: nums) {
      count[n + offset]++;
    }

    // If a number is free to either start a new subsequence or append to an existing subsequence,
    // it is always preferable to append instead of starting a new one.
    // As starting a new won't have any benefit due to the following reason:
    // - Starting a new requires us to add at least 2 elements after it
    // - No such restriction for appending to existing subsequences
    for (int i = 0; i < rangeLength; i++) {
      if (count[i] < 0) {
        return false;
      }

      if (i < rangeLength) {
        // Check how many n we can put to existing subsequence
        int extendCount = Math.min(count[i], i == 0 ? 0 : end[i - 1]);
        // Put to existing subsequence
        end[i] += extendCount;
        // Remove settled number from count
        count[i] -= extendCount;
        // Take n + 1 and n + 2 and put them in the new sequence
        count[i + 1] -= count[i];
        count[i + 2] -= count[i];
        // Update new subsequence ending count
        end[i + 2] += count[i];
      }
    }
    return true;
  }
}

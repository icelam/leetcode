class Solution {
  private int n;
  private HashMap<Integer, Integer> memo;
  private int[][] gcdResults;

  private int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  /**
    * If you use an int or bool array to record the selection status of each element, as you need to
    * select two different elements each time and enumerate all the cases, you may need to backtrack
    * the marker array each time.
    *
    * Note that 1 <= nums.length <= 14, so we can use binary representation for simplicity:
    * Use each binary bit of an int variable to represent whether the element at the corresponding
    * position in nums has been selected.  That is, if ((state >> i) & 1) == 1, it means nums[i] has
    * been selected.
    *
    * In this way, when i and j positions are selected, int newState = state | (1 << i) | (1 << j);
    * transfer this newState to the next recursion to avoid backtracking selection.
    *
    * Assuming that the number of array elements is n, when all elements are selected,
    * state = (1 << n)-1
    *
    * Since all the selections of the selected two elements must be considered every time, the state
    * will change from 0 to the final state in different processes, and we record the scores
    * obtained during the process. Every time the state reaches the final state, use the score at
    * this time to update result, and keep the larger value.
    *
    * To calculate the score, you need to know the current number of choices, just use the number of
    * 1s in the state / 2, since it is required to start from 1, so:
    * current operation = Integer.bitCount(state) / 2 + 1
    */
  private int backtrack(int state, int[] nums) {
    if (memo.containsKey(state)) {
      return memo.get(state);
    }

    if (state == (1 << n) - 1) {
      return 0;
    }

    int currentOperation = Integer.bitCount(state) / 2 + 1;
    int result = 0;

    for (int i = 0; i < n; i++) {
      if (((state >> i) & 1) == 1) {
        continue;
      }

      for (int j = i + 1; j < n; j++) {
        if (((state >> j) & 1) == 1) {
          continue;
        }

        int newState = state | (1 << i) | (1 << j);
        int currentScore = currentOperation * gcdResults[i][j];

        result = Math.max(result, currentScore + backtrack(newState, nums));
      }
    }

    memo.put(state, result);
    return result;
  }

  public int maxScore(int[] nums) {
    n = nums.length;
    memo = new HashMap<>();
    gcdResults = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        gcdResults[i][j] = gcd(nums[i], nums[j]);
      }
    }

    return backtrack(0, nums);
  }
}

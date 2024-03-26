class Solution {
  /*
  * Since length of the array is n, then answer must be an integer between [1, n + 1].
  * If 1 to n all appear in the array, answer will be n + 1.
  * If one of the numbers is missing, then the problem is transformed into counting the occurrences
  * of 1 to n in the array.
  *
  * Algorithm:
  * 1. Change all the numbers that are <= 0 or > n to 0. This will leave only the numbers between
  *    [1, n] in the array, which is convenient for our subsequent processing.
  * 2. Set nums[i - 1] = -1 to indicate that i has appeared in the array. Set 0 to any array cell
  *    which it's value does not lies between [1, n]. When we mark -1 to any cell which has value >
  *    0, which means the value hasn't been processed and we have to continue swaping and processing
  *    until all values in array becomes -1 or 0.
  * 3. Locate the first non -1 value and return as result. If there is no value marked as -1, it
  *    simpily means that all integer between [1, n] exists, the answer will be n + 1.
  */
  public int firstMissingPositive(int[] nums) {
    int n = nums.length;

    for (int i = 0; i < n; i++) {
      if (nums[i] <= 0 || nums[i] > n) {
        nums[i] = 0;
      }
    }


    for (int i = 0; i < n; i++) {
      int j = nums[i];

      if (j > 0) {
        nums[i] = 0;
      }

      while (j > 0) {
        int temp = nums[j - 1];
        nums[j - 1] = -1;
        j = temp;
      }
    }

    for (int i = 0; i < n; i++) {
      if (nums[i] != -1) {
        return i + 1;
      }
    }

    return n + 1;
  }
}

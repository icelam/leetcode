class Solution {
  public int maximumUniqueSubarray(int[] nums) {
    int score = 0;
    int maxScore = 0;
    int[] count = new int[100000];
    int left = 0;
    int right = 0;

    while (right < nums.length) {
      if (count[nums[right] - 1] == 1) {
        maxScore = Math.max(maxScore, score);
      }

      while (count[nums[right] - 1] == 1 && left <= right) {
        score -= nums[left];
        count[nums[left] - 1]--;
        left++;
      }

      score += nums[right];
      count[nums[right] - 1]++;
      right++;
    }

    return Math.max(maxScore, score);
  }
}

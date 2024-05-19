class Solution {
  public long maximumValueSum(int[] nums, int k, int[][] edges) {
    // Number of changes made
    int changes = 0;
    // Minimum gain made by a change
    int minGained = Integer.MAX_VALUE;
    // Minimum loss if a change is made
    int minLoss = Integer.MIN_VALUE;
    // Curent tree sum
    long sum = 0;

    for (int num: nums) {
      sum += num;
    }

    for (int num: nums) {
      int diff = (num ^ k) - num;

      // If performing XOR operation results in a larger tree sum,
      // accept the change first.
      // If the operation results in a loss, record the smallest possible loss for later use.
      if (diff > 0) {
        changes++;
        sum += diff;

        if (diff < minGained) {
          minGained = diff;
        }
      } else if (diff > minLoss) {
        minLoss = diff;
      }
    }

    // Since it is only possible to change even number of nodes,
    // we need to choose whether we need to give up gained change or accept a smaller loss
    if (changes % 2 == 0) {
      return sum;
    }

    return sum + Math.max(minLoss, -minGained);
  }
}

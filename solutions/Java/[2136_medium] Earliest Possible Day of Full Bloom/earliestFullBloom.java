class Solution {
  public int earliestFullBloom(int[] plantTime, int[] growTime) {
    int n = plantTime.length;
    int[][] seeds = new int[plantTime.length][2];

    for (int i = 0; i < n; i++) {
      seeds[i] = new int[] {plantTime[i], growTime[i]};
    }

    Arrays.sort(seeds, (a, b) -> b[1] == a[1] ? b[0] - a[0] : b[1] - a[1]);

    int result = 0;
    int previousEndDate = -1;

    for (int[] seed: seeds) {
      result = Math.max(result, previousEndDate + seed[0] + seed[1] + 1);
      previousEndDate += seed[0];
    }

    return result;
  }
}

class Solution {
  public long maxKelements(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    for (int value: nums) {
      pq.add(value);
    }

    long totalScore = 0;

    while (k > 0) {
      int currentScore = pq.remove();
      totalScore += currentScore;
      pq.add((int) Math.ceil((double) currentScore / 3));
      k--;
    }

    return totalScore;
  }
}

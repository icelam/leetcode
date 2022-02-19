class Solution {
  public int minimumDeviation(int[] nums) {
    PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>(nums.length, Collections.reverseOrder());
    int min = 0;
    int minDeviation = Integer.MAX_VALUE;

    for (int n: nums) {
      if (n % 2 != 0) {
        n *= 2;
      }

      maxPriorityQueue.add(n);
      min = Math.min(min, n);
    }

    while (maxPriorityQueue.peek() % 2 == 0) {
      int temp = maxPriorityQueue.remove() / 2;
      maxPriorityQueue.add(temp);
      min = Math.min(min, temp);
      minDeviation = Math.min(minDeviation, temp - min);
    }

    System.out.println(maxPriorityQueue.toString());

    return  minDeviation;
  }
}

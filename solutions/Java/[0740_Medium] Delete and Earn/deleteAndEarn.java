class Solution {
  public int deleteAndEarn(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int n: nums) {
      map.put(n, map.getOrDefault(n, 0) + n);
    }

    List<Integer> set = new ArrayList<Integer>(map.keySet());
    Collections.sort(set);

    int twoBackSum = 0;
    int oneBackSum = map.get(set.get(0));

    for (int i = 1; i < set.size(); i++) {
      int currentNumber = set.get(i);
      int currentSum = map.get(currentNumber);
      int temp = oneBackSum;

      if (currentNumber == set.get(i - 1) + 1) {
        oneBackSum = Math.max(oneBackSum, twoBackSum + currentSum);
      } else {
        oneBackSum += currentSum;
      }

      twoBackSum = temp;
    }

    return oneBackSum;
  }
}

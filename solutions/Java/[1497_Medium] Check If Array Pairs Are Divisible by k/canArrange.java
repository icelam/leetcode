class Solution {
  public boolean canArrange(int[] arr, int k) {
    Map<Integer, Integer> remainderCount = new HashMap<>();

    for (int i: arr) {
      int reminder = ((i % k) + k) % k;
      remainderCount.put(reminder, remainderCount.getOrDefault(reminder, 0) + 1);
    }

    for (int i: arr) {
      int reminder = ((i % k) + k) % k;

      if (reminder == 0) {
        if (remainderCount.get(reminder) % 2 == 1) {
          return false;
        }
      } else if (!remainderCount.get(reminder).equals(remainderCount.get(k - reminder))) {
        return false;
      }
    }

    return true;
  }
}

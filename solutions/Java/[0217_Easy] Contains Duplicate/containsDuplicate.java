class Solution {
  public boolean containsDuplicate(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int n: nums) {
      if (map.containsKey(n)) {
        return true;
      }

      map.put(n, 1);
    }

    return false;
  }
}

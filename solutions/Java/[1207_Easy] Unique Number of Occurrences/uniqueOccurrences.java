class Solution {
  public boolean uniqueOccurrences(int[] arr) {
    HashMap<Integer, Integer> count = new HashMap<>();

    for (int n: arr) {
      count.put(n, count.getOrDefault(n, 0) + 1);
    }

    HashSet<Integer> set = new HashSet<>();

    for (int c: count.values()) {
      if (set.contains(c)) {
        return false;
      }

      set.add(c);
    }

    return true;
  }
}

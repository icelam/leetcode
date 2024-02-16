class Solution {
  public int findLeastNumOfUniqueInts(int[] arr, int k) {
    int n = arr.length;
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int value: arr) {
      map.put(value, map.getOrDefault(value, 0) + 1);
    }

    Integer[] frequency = map.values().toArray(new Integer[0]);
    Arrays.sort(frequency);

    int uniqueCount = frequency.length;
    int removedCount = 0;

    while (removedCount < uniqueCount && frequency[removedCount] <= k) {
      k -= frequency[removedCount];
      removedCount++;
    }

    return uniqueCount - removedCount;
  }
}

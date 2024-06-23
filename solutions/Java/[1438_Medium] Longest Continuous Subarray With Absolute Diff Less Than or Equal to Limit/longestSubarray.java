class Solution {
  public int longestSubarray(int[] nums, int limit) {
    int n = nums.length;
    int left = 0;
    int right = 0;
    int result = 0;

    /**
     * If we traverse to find the maximum and minimum values in the sliding window,
     * time complexity will be O(k), where k = size of sliding window. This is not efficient enough.
     * Main point:
     * - This problem requires saving all elements in sliding window (which may contains duplicate),
     *   we can use C++ multiset or Java TreeMap (according to hint1).
     * - In C++, the elements of set / multiset / map are ordered, and they are all implemented
     *   based on red-black trees. Among them, set will deduplicate elements, while multiset can
     *   have duplicate elements, and map is a key-ordered hash table.
     * - In Java, TreeSet is an ordered deduplicated set, and TreeMap is a key-ordered hash table,
     *   which are also implemented based on red-black trees.
     * - When inserting and deleting elements frequently, ordered data structures such as
     *   multiset / map and TreeMap can adjust BST within the time complexity of O(log(k))
     *   to maintain the order of the structure.
     * - Both multiset and TreeMap provide functions to get the first and last elements,
     *   which means that the minimum and maximum values in the sliding window can be obtained
     *   within O(1) time.
     */
    TreeMap<Integer, Integer> map = new TreeMap<>();

    while (right < n) {
      map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

      while (map.lastKey() - map.firstKey() > limit) {
        map.put(nums[left], map.get(nums[left]) - 1);

        if (map.get(nums[left]) == 0) {
          map.remove(nums[left]);
        }

        left++;
      }

      result = Math.max(result, right - left + 1);
      right++;
    }

    return result;
  }
}

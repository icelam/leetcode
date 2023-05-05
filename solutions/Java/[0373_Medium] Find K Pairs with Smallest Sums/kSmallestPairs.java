class Solution {
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    int m = nums1.length;
    int n = nums2.length;
     ArrayList<List<Integer>> result = new ArrayList<>();

    PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));

    for (int i = 0; i < Math.min(k, m); i++) {
      heap.add(new int[] {i, 0});
    }

    while (k-- > 0 && !heap.isEmpty()) {
      int[] smallestPairIndices = heap.remove();
      result.add(Arrays.asList(nums1[smallestPairIndices[0]], nums2[smallestPairIndices[1]]));

      if (smallestPairIndices[1] + 1 < n) {
        heap.add(new int[]{smallestPairIndices[0], smallestPairIndices[1] + 1});
      }
    }

    return result;
  }
}

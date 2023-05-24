class Solution {
  public long maxScore(int[] nums1, int[] nums2, int k) {
    int n = nums1.length;
    Integer [] indices = new Integer[n];

    for (int i = 0; i < n; i++){
      indices[i] = i;
    }

    Arrays.sort(indices, (a, b) -> nums2[b] - nums2[a]);

    long result = 0;
    long sum = 0;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int i: indices){
      while (minHeap.size() > k - 1){
        sum -= minHeap.remove();
      }

      minHeap.add(nums1[i]);
      sum += nums1[i];

      if (minHeap.size() == k){
        result = Math.max(result, sum * nums2[i]);
      }
    }

    return result;
  }
}

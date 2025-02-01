class Solution {
  public int findShortestSubArray(int[] nums) {
    int n = nums.length;
    HashMap<Integer, List<Integer>> indices = new HashMap<>();

    for (int i = 0; i < n; i++) {
      indices.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
    }

    int maxOccurance = 0;
    int minLength = Integer.MAX_VALUE;

    for (List<Integer> currentIndices : indices.values()) {
      int currentOccurance = currentIndices.size();
      if (currentOccurance > maxOccurance) {
        minLength = Integer.MAX_VALUE;
        maxOccurance = currentOccurance;
      }

      if (currentOccurance == maxOccurance) {
        int currentLength = currentIndices.get(currentIndices.size() - 1) - currentIndices.get(0) + 1;
        minLength = Math.min(minLength, currentLength);
      }
    }

    return minLength == Integer.MAX_VALUE ? 0 : minLength;
  }
}

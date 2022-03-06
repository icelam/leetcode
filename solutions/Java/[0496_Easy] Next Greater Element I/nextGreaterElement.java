class Solution {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int[] result = new int[nums1.length];
    Stack<Integer> stack = new Stack<>();

    HashMap<Integer, Integer> greaterMap = new HashMap();

    for (int i = nums2.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && nums2[i] > stack.peek()) {
        stack.pop();
      }

      if (!stack.isEmpty()) {
        greaterMap.put(nums2[i], stack.peek());
      }

      stack.push(nums2[i]);
    }

    for (int i = 0; i < nums1.length; i++) {
      result[i] = greaterMap.getOrDefault(nums1[i], -1);
    }

    return result;
  }
}

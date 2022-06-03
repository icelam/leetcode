class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] list = new int[Math.max(nums1.length, nums2.length)];
    int length = 0;

    for (int m: nums1) {
      map.put(m, map.getOrDefault(m, 0) + 1);
    }

    for (int n: nums2) {
      if (map.getOrDefault(n, 0) > 0) {
        map.put(n, map.get(n) - 1);
        list[length] = n;
        length++;
      }
    }

    if (length == 0) {
      return new int[0];
    }

    return Arrays.copyOfRange(list, 0, length);
  }
}

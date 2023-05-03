class Solution {
  public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
    HashSet<Integer> set1 = new HashSet<>();
    HashSet<Integer> set2 = new HashSet<>();

    for (int n: nums1) {
      set1.add(n);
    }

    for (int n: nums2) {
      set2.add(n);
    }

    ArrayList<Integer> result1 = new ArrayList();

    for (int num: set1) {
      if (!set2.contains(num)) {
        result1.add(num);
      }
    }

    ArrayList<Integer> result2 = new ArrayList();

    for (int num: set2) {
      if (!set1.contains(num)) {
        result2.add(num);
      }
    }

    ArrayList<List<Integer>> result = new ArrayList<>();
    result.add(result1);
    result.add(result2);
    return result;
  }
}

class Solution {
  public void swap(int left, int right, List<Integer> list) {
    if (left == right) {
      return;
    }

    int temp = list.get(left);
    list.set(left, list.get(right));
    list.set(right, temp);
  }

  public List<List<Integer>> permute(int[] nums) {
    int length = nums.length;
    int left = 0;
    LinkedList<List<Integer>> result = new LinkedList<>();

    List<Integer> initialList = new LinkedList<>();
    for (int n: nums) {
      initialList.add(n);
    }
    result.add(initialList);

    while (left < length) {
      int batchSize = result.size();
      while (batchSize > 0) {
        List<Integer> currentItem = result.removeFirst();
        for (int right = left; right < length; right++) {
          List<Integer> newItem = new LinkedList<Integer>(currentItem);
          swap(left, right, newItem);
          result.add(newItem);
        }
        batchSize--;
      }
      left++;
    }

    return result;
  }
}

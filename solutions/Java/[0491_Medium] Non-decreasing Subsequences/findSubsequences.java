class Solution {
  public void backtrack(int[] nums, int length, int index, List<Integer> validSubSequence, HashSet<List<Integer>> result) {
    if (index >= length && validSubSequence.size() > 1) {
      result.add(new ArrayList<>(validSubSequence));
      return;
    }

    if (index >= length) {
      return;
    }

    boolean shouldAddNumber = (
      validSubSequence.isEmpty()
      || nums[index] >= validSubSequence.get(validSubSequence.size() - 1)
    );

    if (shouldAddNumber) {
      validSubSequence.add(nums[index]);
      backtrack(nums, length, index + 1, validSubSequence, result);
      validSubSequence.remove(validSubSequence.size() - 1);
    }

    backtrack(nums, length, index + 1, validSubSequence, result);
  }

  public List<List<Integer>> findSubsequences(int[] nums) {
    int length = nums.length;
    HashSet<List<Integer>> result = new HashSet<List<Integer>>();

    backtrack(nums, length, 0, new ArrayList<Integer>(), result);

    return new ArrayList<>(result);
  }
}

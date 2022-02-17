class Solution {
  private List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    backtrackCombination(0, target, candidates, new ArrayList<>());
    return result;
  }

  public void backtrackCombination(int start, int target, int[] candidates, List<Integer> combination) {
    if (target < 0) {
      return;
    }

    if (target == 0) {
      result.add(new ArrayList(combination));
      return;
    }

    for (int i = start; i < candidates.length; i++) {
      combination.add(candidates[i]);
      backtrackCombination(i, target - candidates[i], candidates, combination);
      combination.remove(combination.size() - 1);
    }
  }
}

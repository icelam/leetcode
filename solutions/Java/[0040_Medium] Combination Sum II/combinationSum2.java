class Solution {
  private List<List<Integer>> result;

  public void backtrackCombination(int start, int target, int[] candidates, List<Integer> combination) {
    if (target < 0) {
      return;
    }

    if (target == 0) {
      result.add(new ArrayList(combination));
      return;
    }

    for (int i = start; i < candidates.length; i++) {


      if (i > start && candidates[i] == candidates[i - 1]) {
        continue;
      }

      combination.add(candidates[i]);
      backtrackCombination(i + 1, target - candidates[i], candidates, combination);
      combination.remove(combination.size() - 1);
    }
  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    result = new ArrayList<>();
    Arrays.sort(candidates);
    backtrackCombination(0, target, candidates, new ArrayList<>());
    return result;
  }
}

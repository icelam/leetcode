function combinationSum(candidates: number[], target: number): number[][] {
  const result: number[][] = [];

  function backtrackCombination(
    start: number, balance: number, nums: number[], combination: number[]
  ) {
    if (balance < 0) {
      return;
    }

    if (balance === 0) {
      result.push([...combination]);
      return;
    }

    for (let i = start; i < nums.length; i++) {
      combination.push(nums[i]);
      backtrackCombination(i, balance - nums[i], nums, combination);
      combination.pop();
    }
  }

  backtrackCombination(0, target, candidates, []);
  return result;
}

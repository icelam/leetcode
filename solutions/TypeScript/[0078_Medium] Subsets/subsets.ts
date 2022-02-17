function subsets(nums: number[]): number[][] {
  const result: number[][] = [];
  const queue: number[] = [];

  function backtrack(start = 0) {
    result.push(Array.from(queue));

    for (let i = start; i < nums.length; i++) {
      queue.push(nums[i]);
      backtrack(i + 1);
      queue.pop();
    }
  }

  backtrack();

  return result;
}

function subsets(nums: number[]): number[][] {
  const results: number[][] = [[]];
  for (const n of nums) {
    const queue: number[][] = [];

    for (const subset of results) {
      const newSubset = Array.from(subset);
      newSubset.push(n);
      queue.push(newSubset);
    }

    for (const subset of queue) {
      results.push(subset);
    }
  }

  return results;
}

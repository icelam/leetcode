function subsets(nums: number[]): number[][] {
  let results: number[][] = [[]];
  for (let n of nums) {
    let queue: number[][] = [];

    for(let subset of results) {
      const newSubset = Array.from(subset);
      newSubset.push(n);
      queue.push(newSubset);
    }

    for (let subset of queue) {
      results.push(subset);
    }
  }

  return results;
};

console.log(subsets([1, 2, 3]))

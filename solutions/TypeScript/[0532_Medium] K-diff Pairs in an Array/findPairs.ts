function findPairs(nums: number[], k: number): number {
  const hashTable: Record<number, number> = {};

  for (let i = 0; i < nums.length; i++) {
    hashTable[nums[i]] = (hashTable[nums[i]] ?? 0) + 1;
  }

  let count = 0;

  for (const num of Object.keys(hashTable).map(Number)) {
    if (k === 0 && hashTable[num] >= 2) {
      count++;
    } else if (k > 0 && hashTable[num + k]) {
      count++;
    }
  }

  return count;
}

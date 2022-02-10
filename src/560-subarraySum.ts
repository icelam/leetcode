function subarraySum(nums: number[], k: number): number {
  let prefixSum = 0;
  let count = 0;
  const hashTable: Record<number, number> = { 0: 1 };

  for (let i = 0; i < nums.length; i++) {
    prefixSum = prefixSum + nums[i];
    count += (hashTable[prefixSum - k] ?? 0);
    hashTable[prefixSum] = (hashTable[prefixSum] ?? 0) + 1;
  }

  return count;
};

function findMaxLength(nums: number[]): number {
  let prefixSum: number = 0;
  let previousStopIndex: number = 0;
  let maxLength: number = 0;
  const hashTable: Record<number, number> = {};

  for (let i = 0; i < nums.length; i++) {
    prefixSum += nums[i] === 0 ? 1 : -1;

    if(prefixSum === 0) {
      maxLength = i + 1;
    }

    if (prefixSum in hashTable) {
      maxLength = Math.max(maxLength, i - hashTable[prefixSum]);
    } else {
      hashTable[prefixSum] = i;
    }
  }

  return maxLength;
};

function fourSumCount(nums1: number[], nums2: number[], nums3: number[], nums4: number[]): number {
  let zeroSumTuplesCount = 0;
  const hashTable: Record<number, number> = {};

  for (let i = 0; i < nums1.length; i++) {
    for (let j = 0; j < nums2.length; j++) {
      const sum = nums1[i] + nums2[j];
      hashTable[sum] = (hashTable[sum] ?? 0) + 1;
    }
  }

  for (let k = 0; k < nums3.length; k++) {
    for (let l = 0; l < nums4.length; l++) {
      const sum = -(nums3[k] + nums4[l]);
      if (hashTable[sum]) {
        zeroSumTuplesCount += hashTable[sum];
      }
    }
  }

  return zeroSumTuplesCount;
}

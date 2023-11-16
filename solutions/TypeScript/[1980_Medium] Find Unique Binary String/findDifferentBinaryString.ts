function findDifferentBinaryString(nums: string[]): string {
  nums.sort();

  const n = nums.length;
  let missingNum = 0;

  while (missingNum < n && parseInt(nums[missingNum], 2) === missingNum) {
    missingNum++;
  }

  const missingBinary = missingNum.toString(2);
  const zeroPadLength = n - missingBinary.length;
  return '0'.repeat(zeroPadLength) + missingBinary;
}

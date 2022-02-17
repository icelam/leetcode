function findMaxConsecutiveOnes(nums: number[]): number {
  let max = 0;
  let count = 0;

  for (const n of nums) {
    if (n === 1) {
      count++;
    } else {
      if (count > max) {
        max = count;
      }
      count = 0;
    }
  }

  return count > max ? count : max;
}

function sortedSquares(nums: number[]): number[] {
  let i = 0;
  let j = nums.length - 1;
  const result: number[] = [];

  for (let k = nums.length - 1; k >= 0; k--) {
    if (Math.abs(nums[i]) >= Math.abs(nums[j])) {
      result[k] = Math.pow(nums[i], 2);
      i++;
    } else {
      result[k] = Math.pow(nums[j], 2);
      j--;
    }
  }

  return result;
}

function maxSubArray(nums: number[]): number {
  let result = nums[0];
  let currentSum = 0;

  for(let n of nums) {
    currentSum += n;

    if (currentSum > result) {
      result = currentSum;
    }

    if (currentSum < 0) {
      currentSum = 0;
    }
  }

  return result;
};

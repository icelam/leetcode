function missingNumber(nums: number[]): number {
  let accumulator = 0;
  const arraySum = nums.forEach((n, currentIndex) => {
    accumulator += currentIndex +1;
    accumulator -= n;
  });

  return accumulator;
};

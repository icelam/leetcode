function sortedSquares(nums: number[]): number[] {
  for(let i = 0; i < nums.length; i++) {
    nums[i] = Math.pow(nums[i], 2);
  }

  // insertion sort
  let i, key, j;
  for (i = 1; i < nums.length; i++){
    key = nums[i];
    j = i - 1;

    while (j >= 0 && nums[j] > key) {
      nums[j + 1] = nums[j];
      j = j - 1;
    }
    nums[j + 1] = key;
  }

  return nums;
};

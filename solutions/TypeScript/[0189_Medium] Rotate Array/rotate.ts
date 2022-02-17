function rotate(nums: number[], k: number): void {
  for (let i = 0; i < k % nums.length; i++) {
    const lastItem = nums[nums.length - 1];
    for (let j = nums.length - 2; j >= 0; j--) {
      nums[j + 1] = nums[j];
    }
    nums[0] = lastItem;
  }
}

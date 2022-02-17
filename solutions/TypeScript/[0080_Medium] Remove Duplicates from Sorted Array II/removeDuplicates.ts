function removeDuplicates(nums: number[]): number {
  let { length } = nums;
  let current = 2;

  while (nums[current] !== undefined) {
    const value = nums[current];

    if (nums[current - 1] === nums[current] && nums[current - 2] === nums[current]) {
      for (let i = current; i < length; i++) {
        nums[i] = nums[i + 1];
      }
      length--;
    } else {
      current++;
    }
  }

  return length;
}

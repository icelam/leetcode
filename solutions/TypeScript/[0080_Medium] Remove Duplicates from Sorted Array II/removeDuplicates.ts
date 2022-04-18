function removeDuplicates(nums: number[]): number {
  let { length } = nums;
  let current = 2;

  while (current < length) {
    if (nums[current - 1] === nums[current] && nums[current - 2] === nums[current]) {
      for (let i = current; i < length - 1; i++) {
        nums[i] = nums[i + 1];
      }
      length--;
    } else {
      current++;
    }
  }

  return length;
}

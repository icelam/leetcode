function reverseSubArray(nums: number[], start: number, end: number) {
  while (start <= end) {
    const temp = nums[start];
    nums[start] = nums[end];
    nums[end] = temp;
    start++;
    end--;
  }
}

function rotate(nums: number[], k: number): void {
  const numberOfShift = k % nums.length;
  reverseSubArray(nums, 0, nums.length - 1);
  reverseSubArray(nums, 0, numberOfShift - 1);
  reverseSubArray(nums, numberOfShift, nums.length - 1);
}

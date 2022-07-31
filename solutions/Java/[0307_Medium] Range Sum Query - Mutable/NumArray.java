class NumArray {
  private int length;
  private int[] nums;
  private int sum;

  public NumArray(int[] nums) {
    this.length = nums.length;
    this.nums = nums;

    for (int i = 0; i < length; i++) {
      sum += nums[i];
    }
  }

  public void update(int index, int val) {
    sum += val - nums[index];
    nums[index] = val;
  }

  public int sumRange(int left, int right) {
    int leftSum = 0;
    int rightSum = 0;

    for (int i = 0; i < left; i++) {
      leftSum += nums[i];
    }

    for (int j = right + 1; j < length; j++) {
      rightSum += nums[j];
    }

    return sum - leftSum - rightSum;
  }
}

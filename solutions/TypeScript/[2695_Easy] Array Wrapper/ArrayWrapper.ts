class ArrayWrapper {
  private numsArray: number[];

  private value: number;

  private stringifiedValue: string;

  constructor(nums: number[]) {
    this.numsArray = nums;
    this.value = nums.reduce((accmulator, current) => (accmulator + current), 0);
    this.stringifiedValue = JSON.stringify(this.numsArray);
  }

  valueOf() {
    return this.value;
  }

  toString() {
    return this.stringifiedValue;
  }
}

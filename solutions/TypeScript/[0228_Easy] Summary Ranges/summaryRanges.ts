function formatResultString(start: number, end: number) {
  let str = '';
  str += start;

  if (start !== end) {
    str += '->';
    str += end;
  }

  return str.toString();
}

function summaryRanges(nums: number[]): string[] {
  const result: string[] = [];

  if (nums.length === 0) {
    return result;
  }

  let start = nums[0];
  let end = nums[0];

  for (let i = 0; i < nums.length; i++) {
    if (i < nums.length && i !== 0 && nums[i] - 1 !== nums[i - 1]) {
      result.push(formatResultString(start, end));
      start = nums[i];
    }

    end = nums[i];
  }

  result.push(formatResultString(start, end));

  return result;
}

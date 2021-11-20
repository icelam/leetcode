// Should be correct, however it exceed time limit
function findDifferentBinaryString(nums: string[]): string {
  const numCount: Record<string, number> = {};

  for(const n of nums) {
    numCount[n] = (numCount[n] ?? 0) + 1;
  }

  // generate binary numbers one by one
  const prefixes: string[] = ['0', '1'];

  while(prefixes[0].length < nums.length + 1) {
    prefixes.push(prefixes[0] + '0');
    prefixes.push(prefixes[0] + '1');

    const processedNumber = prefixes.shift() as string;
    if (processedNumber.length === nums.length && !numCount[processedNumber]) {
      return processedNumber;
    }
  }

  return '';
};

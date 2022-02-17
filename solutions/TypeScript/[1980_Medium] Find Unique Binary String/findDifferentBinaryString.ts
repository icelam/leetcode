function findDifferentBinaryString(nums: string[]): string {
  const numCount: Record<string, number> = {};

  for (const n of nums) {
    const decimal = parseInt(n, 2);

    numCount[decimal] = (numCount[decimal] ?? 0) + 1;
  }

  for (let i = 0; i < Math.pow(2, 16); i++) {
    if (!numCount[i]) {
      const binaryString = i.toString(2);

      return binaryString.length >= nums.length
        ? binaryString
        : new Array(nums.length - binaryString.length + 1).join('0') + binaryString;
    }
  }

  return new Array(nums.length + 1).join('0');
}

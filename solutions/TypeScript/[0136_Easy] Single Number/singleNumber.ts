function singleNumber(nums: number[]): number {
  const hashMap = {};
  nums.forEach((n) => {
    if (hashMap[n]) {
      hashMap[n]++;
    } else {
      hashMap[n] = 1;
    }
  });

  return [...new Set(nums)].find((n) => hashMap[n] === 1);
}

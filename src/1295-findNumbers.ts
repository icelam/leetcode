function findNumbers(nums: number[]): number {
  let count = 0;

  for (const n of nums) {
    let temp = n;
    let digits = 0;

    do {
      digits++;
      temp /= 10;
    } while (temp >= 1);

    if (digits % 2 === 0) {
      count++;
    }
  }

  return count;
};

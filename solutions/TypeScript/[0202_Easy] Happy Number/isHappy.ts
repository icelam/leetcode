function isHappy(n: number): boolean {
  const hashMap: Record<number, number> = {};
  let squaresSum = n;

  while (squaresSum !== 1) {
    const nums = String(squaresSum).split('');
    squaresSum = nums.reduce((i, num) => (Math.pow(Number(num), 2) + i), 0);

    if (hashMap[squaresSum]) {
      return false;
    }

    hashMap[squaresSum] = 1;
  }

  return true;
}

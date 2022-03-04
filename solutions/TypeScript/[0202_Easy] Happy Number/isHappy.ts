function isHappy(n: number): boolean {
  const hashMap: Record<number, number> = {};
  let squaresSum = n;

  while (squaresSum !== 1) {
    let temp = 0;
    for (let i = squaresSum; i > 0; i = Math.floor(i / 10)) {
      temp += Math.pow(i % 10, 2);
    }
    squaresSum = temp;

    if (hashMap[squaresSum]) {
      return false;
    }

    hashMap[squaresSum] = 1;
  }

  return true;
}

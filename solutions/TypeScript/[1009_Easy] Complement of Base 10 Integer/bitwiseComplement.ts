function bitwiseComplement(n: number): number {
  if (n === 0) {
    return 1;
  }

  let num = n;
  const bitLength = Math.floor(Math.log(num) / Math.log(2)) + 1;

  for (let i = 0; i < bitLength; i++) {
    num ^= 1 << i;
  }

  return num;
}

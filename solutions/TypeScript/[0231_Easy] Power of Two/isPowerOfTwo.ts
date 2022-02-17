function isPowerOfTwo(n: number): boolean {
  while (n > 1) {
    n /= 2;
  }

  return n === 1;
}

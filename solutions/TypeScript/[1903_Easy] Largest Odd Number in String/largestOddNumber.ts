function largestOddNumber(num: string): string {
  for (let i = num.length - 1; i >= 0; i--) {
    const n = num.substring(0, i + 1);
    if (Number(n[(n.length - 1)]) % 2 === 1) {
      return n;
    }
  }

  return '';
}

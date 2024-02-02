function sequentialDigits(low: number, high: number): number[] {
  const result: number[] = [];

  for (let i = 0; i < 10; i++) {
    let num = 0;

    for (let j = i + 1; j < 10; j++) {
      num *= 10;
      num += j;

      if (num > high) {
        break;
      }

      if (num >= low && num <= high) {
        result.push(num);
      }
    }
  }

  result.sort((a, b) => a - b);
  return result;
}

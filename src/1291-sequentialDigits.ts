function getExponent (n: number): number {
  return Math.floor(Math.log10(n));
}

function getFirstDigit (n: number): number {
  return Math.floor(n / Math.pow(10, getExponent(n)));
}

function sequentialDigits(low: number, high: number): number[] {
  let result: number[] = []

  for(let i = low; i < high; i = (getFirstDigit(i) + 1) * Math.pow(10, getExponent(i))) {
    const firstDigit = getFirstDigit(i);

    if (firstDigit + getExponent(i) > 9) {
      continue;
    }

    let sequentialDigits = 0;
    for (let j = getExponent(i); j >= 0; j--) {
      sequentialDigits += (getExponent(i) - j + firstDigit) * Math.pow(10, j);
    }

    if (sequentialDigits >= low && sequentialDigits <= high) {
      result.push(sequentialDigits)
    }
  }

  return result;
};

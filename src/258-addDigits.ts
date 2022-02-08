function addDigits(num: number): number {
  let sum;

  do {
    sum = 0;

    for (let i = num; i > 0; i = Math.floor(i / 10)) {
        sum += i % 10;
    }

    num = sum;
  } while (sum >= 10);

  return sum;
};

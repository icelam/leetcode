function areNumbersAscending(s: string): boolean {
  const numbers = s
    .split(' ')
    .map((character) => Number(character))
    .filter(n => !isNaN(n));

  for(let i = 0; i < numbers.length; i++) {
    const previous = i === 0 ? -1 : Number(numbers[i - 1]);
    if (Number(numbers[i]) <= previous) {
      return false;
    }
  }

  return true;
};

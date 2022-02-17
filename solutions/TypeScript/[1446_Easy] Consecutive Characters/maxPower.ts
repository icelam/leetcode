function maxPower(str: string): number {
  let previousCharacter = '';
  let currentCount = 0;
  let maxCount = 0;

  for (const character of str) {
    if (previousCharacter !== character) {
      if (currentCount > maxCount) {
        maxCount = currentCount;
      }
      currentCount = 0;
      previousCharacter = character;
    }

    currentCount++;
  }

  return currentCount > maxCount ? currentCount : maxCount;
}

function detectCapitalUse(word: string): boolean {
  const isCapitalLetter = (c: string) => (c.charCodeAt(0) >= 65 && c.charCodeAt(0) <= 90);

  let numberOfCapitalLetter = 0;
  const wordLength = word.length;

  for (let i = 0; i < wordLength; i++) {
    if (isCapitalLetter(word[i])) {
      numberOfCapitalLetter++;
    }
  }

  return (
    (isCapitalLetter(word[0]) && numberOfCapitalLetter === 1)
    || numberOfCapitalLetter === wordLength
    || numberOfCapitalLetter === 0
  );
}

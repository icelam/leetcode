function detectCapitalUse(word: string): boolean {
  let isAllCapital = true;
  let isAllLowerCaseAfterFirstLetter = true;

  for (let i = 0; i < word.length; i++) {
    if (!isAllCapital && !isAllLowerCaseAfterFirstLetter) {
      break;
    }

    isAllCapital = isAllCapital && (word.charCodeAt(i) >= 65 && word.charCodeAt(i) <= 90);
    isAllLowerCaseAfterFirstLetter = i === 0
      ? true
      : isAllLowerCaseAfterFirstLetter && (word.charCodeAt(i) >= 97 && word.charCodeAt(i) <= 122);
  }

  return isAllCapital || isAllLowerCaseAfterFirstLetter;
};

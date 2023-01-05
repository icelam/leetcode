function decodeString(s: string): string {
  const isDigit = (c: string): boolean => (
    c.charCodeAt(0) >= '0'.charCodeAt(0) && c.charCodeAt(0) <= '9'.charCodeAt(0)
  );

  const isStartOfRepeatMark = (c: string): boolean => (c === '[');

  const isEndOfRepeatMark = (c: string): boolean => (c === ']');

  const isLetter = (c: string): boolean => (
    !isDigit(c) && !isStartOfRepeatMark(c) && !isEndOfRepeatMark(c)
  );

  const parts: string[] = [];
  const frequencies: number[] = [];
  const n = s.length;
  let i = 0;

  while (i < n) {
    if (isDigit(s[i])) {
      let occurance = 0;

      while (i < n && isDigit(s[i])) {
        occurance = occurance * 10 + parseInt(s[i], 10);
        i++;
      }

      frequencies.push(occurance);
    } else if (isStartOfRepeatMark(s[i])) {
      if (!isLetter(s[i + 1])) {
        parts.push('');
      }

      i++;
    } else if (isEndOfRepeatMark(s[i])) {
      let repeatedPart = '';
      const currentPart = parts.pop();

      for (let occurance = (frequencies.pop() ?? 0); occurance > 0; occurance--) {
        repeatedPart += currentPart;
      }

      if (parts.length) {
        const previousPart = parts.pop();
        repeatedPart = previousPart + repeatedPart;
      }

      parts.push(repeatedPart);
      i++;
    } else {
      let currentPart = '';
      const previousChar = i > 0 ? s[i - 1] : ' ';

      while (i < n && isLetter(s[i])) {
        currentPart += s[i];
        i++;
      }

      if (isEndOfRepeatMark(previousChar)) {
        const previousPart = parts.pop();
        currentPart += previousPart + currentPart;
      }

      parts.push(currentPart);
    }
  }

  return parts.pop() ?? '';
}

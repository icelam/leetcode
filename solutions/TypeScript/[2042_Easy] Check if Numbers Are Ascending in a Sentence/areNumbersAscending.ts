function areNumbersAscending(s: string): boolean {
  const CHAR_CODE_0 = '0'.charCodeAt(0);
  const CHAR_CODE_9 = '9'.charCodeAt(0);

  const parts: string[] = s.split(' ');
  let previous = -1;

  for (const p of parts) {
    if (p.charCodeAt(0) >= CHAR_CODE_0 && p.charCodeAt(0) <= CHAR_CODE_9) {
      let current = 0;

      for (let i = p.length - 1, j = 1; i >= 0; i--, j *= 10) {
        current += (p.charCodeAt(i) - CHAR_CODE_0) * j;
      }

      if (current <= previous) {
        return false;
      }

      previous = current;
    }
  }

  return true;
}

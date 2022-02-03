function findAnagrams(s: string, p: string): number[] {
  const charOffset = 'a'.charCodeAt(0);
  let result: number[] = [];

  const pCharacters: number[] = new Array(26).fill(0);
  const sCharacters: number[] = new Array(26).fill(0);

  // First window
  for (let i = 0; i< p.length; i++) {
    pCharacters[p.charCodeAt(i) - charOffset]++;
    sCharacters[s.charCodeAt(i) - charOffset]++;
  }

  for (let i = p.length - 1; i < s.length; i++) {
    if (i >= p.length) {
      sCharacters[s.charCodeAt(i) - charOffset]++;
      sCharacters[s.charCodeAt(i - p.length) - charOffset]--;
    }

    let isAnagrams = true;

    for (let i = 0; i < 26; i++) {
      if (pCharacters[i] !== sCharacters[i]) {
        isAnagrams = false;
        break;
      }
    }

    if (isAnagrams) {
      result.push(i - (p.length - 1));
    }
  }

  return result;
}

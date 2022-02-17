function findTheDifference(s: string, t: string): string {
  let sSum = 0;
  let xSum = 0;

  for (let i = 0; i < Math.max(s.length, t.length); i++) {
    if (i < s.length) {
      sSum ^= s.charCodeAt(i);
    }

    if (i < t.length) {
      xSum ^= t.charCodeAt(i);
    }
  }

  return String.fromCharCode(sSum ^ xSum);
}

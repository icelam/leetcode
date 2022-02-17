function findTheDifference(s: string, t: string): string {
  let sum = 0;

  for (let i = 0; i < Math.max(s.length, t.length); i++) {
    if (i < s.length) {
      sum -= s.charCodeAt(i);
    }

    if (i < t.length) {
      sum += t.charCodeAt(i);
    }
  }

  return String.fromCharCode(sum);
}

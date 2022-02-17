function minAddToMakeValid(s: string): number {
  let count = 0;
  const buffer: string[] = [];
  for (let i = 0; i < s.length; i++) {
    if (s[i] === ')') {
      if (buffer[buffer.length - 1] !== '(') {
        count++;
      }

      buffer.pop();
    } else {
      buffer.push(s[i]);
    }
  }

  if (buffer.length) {
    count += buffer.length;
  }

  return count;
}

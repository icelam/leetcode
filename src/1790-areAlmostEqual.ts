function areAlmostEqual(s1: string, s2: string): boolean {
  const diff: number[] = [];

  for (let i = 0; i < s1.length; i++) {
    if(s1[i] !== s2[i]) {
      diff.push(i);
    }

    if(diff.length > 2) {
      return false;
    }
  }

  if (diff.length < 2) {
    return !Boolean(diff.length);
  }

  return s1[diff[0]] === s2[diff[1]] && s1[diff[1]] === s2[diff[0]];
};

console.log(areAlmostEqual("ab", "ba"));
console.log(areAlmostEqual("abcd", "dbca"));
console.log(areAlmostEqual("abcd", "abcd"));
console.log(areAlmostEqual("abcd", "axyz"));
console.log(areAlmostEqual("caa", "aaz"));
console.log(areAlmostEqual("ac", "az"));

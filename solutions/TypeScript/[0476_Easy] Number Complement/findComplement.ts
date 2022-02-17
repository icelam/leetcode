function findComplement(num: number): number {
  const binaryBits = num.toString(2).split('');

  return parseInt(binaryBits.map((bit) => (bit === '0' ? '1' : '0')).join(''), 2);
}

function maximumWealth(accounts: number[][]): number {
  let max = 0;

  for(let account of accounts) {
    const total = account.reduce((accumulator, value) => accumulator + value, 0);
    if (total > max) {
      max = total;
    }
  }

  return max;
};

function processEquation (equation: string): string[] {
  // 1. replace leading -
  // 2. replace - to +-
  // 3. split by + to get numbers
  return equation.replace(/^-/, '0-').replace(/-/g, '+-').split('+');
}

// FIXME: this does not handle x as coefficient (e.g. xx)
function countNumberofX (x: string): number {
  let count = 0;
  const [, symbol='+', coefficient = '1'] = x.match(/(-?)(\d+)?(x)/) || [];
  for(let i = Number(coefficient); i > 0; i--) {
    count += (symbol === '-' ? -1 : 1);
  }

  return count;
}

function solveEquation(equation: string): string {
  let numberValue = 0;
  let xCount = 0;

  const [leftEquation, rightEquation] = equation.split('=');

  if (!leftEquation || !rightEquation) {
    return "No solution"
  }

  processEquation(leftEquation).forEach((number) => {
    if (/x/.test(number)) {
      xCount += countNumberofX(number)
    } else {
      numberValue -= Number(number);
    }
  });

  processEquation(rightEquation).forEach((number) => {
    if (/x/.test(number)) {
      xCount -= countNumberofX(number)
    } else {
      numberValue += Number(number);
    }
  });

  if (xCount === 0) {
    return numberValue === 0 ? "Infinite solutions" : "No solution";
  }

  return `x=${numberValue / xCount}`;
};

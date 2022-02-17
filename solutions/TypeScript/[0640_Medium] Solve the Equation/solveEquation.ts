function processEquation(equation: string): string[] {
  const numbers: string[] = [];
  let temp = '';

  for (const char of equation) {
    if (char === '+' || char === '-') {
      if (temp) {
        numbers.push(temp);
      }

      temp = (char === '+' ? '' : '-');
    } else {
      temp += char;
    }
  }

  numbers.push(temp);

  return numbers;
}

function isNumberCharacter(char: string) {
  return char.charCodeAt(0) >= '0'.charCodeAt(0) && char.charCodeAt(0) <= '9'.charCodeAt(0);
}

function countNumberofX(x: string): number {
  let symbol = '+';
  let coefficient = '';
  let count = 0;

  for (const char of x) {
    if (char === '-') {
      symbol = char;
    } else if (isNumberCharacter(char)) {
      coefficient += char;
    }
  }

  for (let i = Number(coefficient || '1'); i > 0; i--) {
    count += (symbol === '-' ? -1 : 1);
  }

  return count;
}

function solveEquation(equation: string): string {
  let numberValue = 0;
  let xCount = 0;

  const [leftEquation, rightEquation] = equation.split('=');

  if (!leftEquation || !rightEquation) {
    return 'No solution';
  }

  processEquation(leftEquation).forEach((number) => {
    if (number.includes('x')) {
      xCount += countNumberofX(number);
    } else {
      numberValue -= Number(number);
    }
  });

  processEquation(rightEquation).forEach((number) => {
    if (number.includes('x')) {
      xCount -= countNumberofX(number);
    } else {
      numberValue += Number(number);
    }
  });

  if (xCount === 0) {
    return numberValue === 0 ? 'Infinite solutions' : 'No solution';
  }

  return `x=${numberValue / xCount}`;
}

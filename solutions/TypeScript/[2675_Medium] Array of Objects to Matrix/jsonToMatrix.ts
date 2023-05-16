type Matrix = (string | number | boolean | null)[][];

function isObjectOrArray(obj: any): boolean {
  if (!obj) {
    return false;
  }

  return Array.isArray(obj) || typeof obj === 'object';
}

function get(obj: any, pointer: string): string {
  let childObject = obj;
  const levels = pointer.split('.');
  let index = 0;

  while (index < levels.length) {
    if (!isObjectOrArray(childObject)) {
      break;
    }

    childObject = childObject[levels[index]];
    index++;
  }

  return (
    index < levels.length || isObjectOrArray(childObject) || typeof childObject === 'undefined'
      ? ''
      : childObject
  );
}

function generateJsonPointers(obj: any, jsonPointer: string, flatternedJsonPointers: Set<string>): void {
  if (obj !== null && (Array.isArray(obj) || typeof obj === 'object')) {
    Object.keys(obj).forEach((key) => {
      generateJsonPointers(
        obj[key],
        !!jsonPointer ? jsonPointer + '.' + key : key,
        flatternedJsonPointers
      );
    });

    return;
  }

  flatternedJsonPointers.add(jsonPointer);
}

function jsonToMatrix(arr: any[]): Matrix {
  const flatternedJsonPointers: Set<string> = new Set();
  for (const row of arr) {
    generateJsonPointers(row, '', flatternedJsonPointers);
  }

  const result: Matrix = [];
  const matrixHeader = Array.from(flatternedJsonPointers).sort();

  result.push(matrixHeader);

  for (const arrayRow of arr) {
    const matrixRow: Matrix[number] = [];
    for (const pointer of matrixHeader) {
      matrixRow.push(get(arrayRow, pointer));
    }
    result.push(matrixRow);
  }

  return result;
}

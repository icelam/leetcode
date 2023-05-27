type ToBeOrNotToBe = {
    toBe: (val: any) => boolean;
    notToBe: (val: any) => boolean;
};

function expect(val: any): ToBeOrNotToBe {
  const toBe = (input: any) => {
    if (input !== val) {
      throw new Error('Not Equal');
    }

    return true;
  };

  const notToBe = (input: any) => {
    if (input === val) {
      throw new Error('Equal');
    }

    return true;
  };

  return { toBe, notToBe };
}

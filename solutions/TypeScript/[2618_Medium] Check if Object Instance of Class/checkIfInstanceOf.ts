function checkIfInstanceOf(obj: any, classFunction: any): boolean {
  return obj === null || obj === undefined || typeof classFunction !== 'function'
    ? false
    : Object(obj) instanceof classFunction;
}

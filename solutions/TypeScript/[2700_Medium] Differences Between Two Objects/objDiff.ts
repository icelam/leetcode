function objDiff(obj1: any, obj2: any): any {
  // String, Number, Boolean or null
  if (obj1 === obj2) {
    return {};
  }

  if (
    obj1 === null
    || obj2 === null
    || Array.isArray(obj1) !== Array.isArray(obj2)
    || typeof obj1 !== 'object'
    || typeof obj2 !== 'object'
  ) {
    return [obj1, obj2];
  }

  const result: Record<string, any> = {};

  for (const key in obj1) {
    if (key in obj2) {
      const difference = objDiff(obj1[key], obj2[key]);
      if (Object.keys(difference).length > 0) {
        result[key] = difference;
      }
    }
  }

  return result;
}

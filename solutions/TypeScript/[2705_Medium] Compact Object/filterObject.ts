type Obj = Record<any, any>;

function filterObject(value: any): any {
  if (value === null || (!Array.isArray(value) && typeof value !== 'object')) {
    return Boolean(value) ? value : null;
  }

  if (Array.isArray(value)) {
    const result: any[] = [];

    for (const child of value) {
      const filteredValue = filterObject(child);
      if (filteredValue !== null) {
        result.push(filteredValue);
      }
    }

    return result;
  }

  if (typeof value === 'object') {
    const result: Record<string, any> = {};

    Object.keys(value).forEach((key) => {
      const filteredValue = filterObject(value[key]);
      if (filteredValue !== null) {
        result[key] = filteredValue;
      }
    });

    return result;
  }

  return value;
}

function compactObject(obj: Obj): Obj {
  return filterObject(obj);
}

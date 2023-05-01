function jsonStringify(object: any): string {
  if (object === null) {
    return 'null';
  }

  if (typeof object === 'string') {
    return `"${object}"`;
  }

  if (typeof object === 'number' || typeof object === 'boolean') {
    return String(object);
  }

  if (Array.isArray(object)) {
    return `[${object.map((item) => jsonStringify(item)).join(',')}]`;
  }

  if (typeof object === 'object') {
    return `{${Object.keys(object).map((key) => `"${key}":${jsonStringify(object[key])}`).join(',')}}`;
  }

  return object;
}

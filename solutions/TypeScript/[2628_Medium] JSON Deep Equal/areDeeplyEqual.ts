function areDeeplyEqual(o1: any, o2: any): boolean {
  if (Array.isArray(o1) !== Array.isArray(o2) || typeof o1 !== typeof o2) {
    return false;
  }

  if (Array.isArray(o1)) {
    if (o1.length !== o2.length) {
      return false;
    }

    for (let i = 0; i < o1.length; i++) {
      if (!areDeeplyEqual(o1[i], o2[i])) {
        return false;
      }
    }

    return true;
  }

  if (o1 !== null && o2 !== null && typeof o1 === 'object') {
    if (Object.keys(o1).length !== Object.keys(o2).length) {
      return false;
    }

    const keys = Object.keys(o1);

    for (let i = 0; i < keys.length; i++) {
      if (!areDeeplyEqual(o1[keys[i]], o2[keys[i]])) {
        return false;
      }
    }

    return true;
  }

  return o1 === o2;
}

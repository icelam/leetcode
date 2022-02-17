function ladderLength(beginWord: string, endWord: string, wordList: string[]): number {
  // Use include for simplicity, O(n)
  if (!wordList.includes(endWord)) {
    return 0;
  }

  const visited = { [beginWord]: 1 };
  const queue = [beginWord];
  let word;

  while (word = queue.pop()) {
    if (word === endWord) {
      break;
    }

    let i = wordList.length;
    while (i--) {
      const newWord = wordList[i];
      let differenceCount = 0;

      for (let j = 0; j < word.length; j++) {
        if (word[j] !== newWord[j]) {
          differenceCount++;
        }
      }

      if (differenceCount === 1 && !visited[newWord]) {
        visited[newWord] = visited[word] + 1;
        queue.unshift(newWord);
        wordList.splice(i, 1);
      }
    }
  }

  return visited[endWord] ?? 0;
}

const beginWord = 'qa';
const endWord = 'sq';
const wordList = ['si', 'go', 'se', 'cm', 'so', 'ph', 'mt', 'db', 'mb', 'sb', 'kr', 'ln', 'tm', 'le', 'av', 'sm', 'ar', 'ci', 'ca', 'br', 'ti', 'ba', 'to', 'ra', 'fa', 'yo', 'ow', 'sn', 'ya', 'cr', 'po', 'fe', 'ho', 'ma', 're', 'or', 'rn', 'au', 'ur', 'rh', 'sr', 'tc', 'lt', 'lo', 'as', 'fr', 'nb', 'yb', 'if', 'pb', 'ge', 'th', 'pm', 'rb', 'sh', 'co', 'ga', 'li', 'ha', 'hz', 'no', 'bi', 'di', 'hi', 'qa', 'pi', 'os', 'uh', 'wm', 'an', 'me', 'mo', 'na', 'la', 'st', 'er', 'sc', 'ne', 'mn', 'mi', 'am', 'ex', 'pt', 'io', 'be', 'fm', 'ta', 'tb', 'ni', 'mr', 'pa', 'he', 'lr', 'sq', 'ye'];
console.log(ladderLength(beginWord, endWord, wordList));

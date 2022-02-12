function ladderLength(beginWord: string, endWord: string, wordList: string[]): number {
  // Use include for simplicity, O(n)
  if (!wordList.includes(endWord)) {
    return 0;
  }

  let depth: number[] = new Array(wordList.length);
  let queue: number[] = [];
  let word: string = beginWord;
  let currentIndex: number | undefined = -1;

  do {
    word = wordList[currentIndex] ?? beginWord;

    for (let i = 0; i < wordList.length; i++) {
      let differenceCount = 0;

      for (let j = 0; j < word.length; j++) {
        if (word[j] !== wordList[i][j]) {
          differenceCount++;
        }
      }

      if (differenceCount === 1 && !depth[i]) {
        depth[i] = (depth[currentIndex] ?? 1) + 1;
        queue.unshift(i);
        if (wordList[i] === endWord) {
          return depth[i];
        }
      }
    }
  } while (currentIndex = queue.pop(), currentIndex !== undefined);

  return 0;
};

// const beginWord = "leet", endWord = "code", wordList = ["lest","lose","code","lode","robe","lost"];
const beginWord = "qa";
const endWord = "sq";
const wordList = ["si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"];
console.log(ladderLength(beginWord, endWord, wordList));

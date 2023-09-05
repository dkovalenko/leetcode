object Solution {
  def checkAlmostEquivalent(word1: String, word2: String): Boolean = {
    //word1 = "abcdeef", word2 = "abaaacc"
    //a => 1, a => 4
    // val freqMap1 = fillFreqMap(word1)
    // val freqMap2 = fillFreqMap(word2)
    val freqMap1 = collection.mutable.Map.empty[Char, Int]

    // for (i <- 'a' to 'z') {
    //   if (Math.abs(freqMap1.getOrElse(i, 0) - freqMap2.getOrElse(i, 0)) > 3)
    //     return false
    // }
    for (i <- 0 until word1.size) {
      freqMap1.get(word1(i)) match {
        case Some(freqDiff) =>
          freqMap1.update(word1(i), freqDiff + 1)
        case None => freqMap1.put(word1(i), 1)
      }
      freqMap1.get(word2(i)) match {
        case Some(freqDiff) => 
          freqMap1.update(word2(i), freqDiff - 1)
        case None => freqMap1.put(word2(i), -1)
      }
      println(freqMap1)
    }
    for (i <- 'a' to 'z') {
      if (Math.abs(freqMap1.getOrElse(i, 0)) > 3)
        return false
    }
    true
  }
  // def fillFreqMap(input: String): collection.mutable.Map[Char, Int] = {
  //   val map = collection.mutable.Map.empty[Char, Int]
  //   input.foreach { char =>
  //     map.get(char) match {
  //       case Some(freq) => map.update(char, freq + 1)
  //       case None => map.put(char, 1)
  //     }
  //   }
  //   map
  // }
}
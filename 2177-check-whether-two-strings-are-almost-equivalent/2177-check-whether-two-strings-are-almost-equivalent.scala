object Solution {
  def checkAlmostEquivalent(word1: String, word2: String): Boolean = {
    //word1 = "abcdeef", word2 = "abaaacc"
    //a => 1, a => 4
    val freqMap1 = fillFreqMap(word1)
    val freqMap2 = fillFreqMap(word2)

    for (i <- 'a' to 'z') {
      if (Math.abs(freqMap1.getOrElse(i, 0) - freqMap2.getOrElse(i, 0)) > 3)
        return false
    }
    true
  }
  def fillFreqMap(input: String): collection.mutable.Map[Char, Int] = {
    val map = collection.mutable.Map.empty[Char, Int]
    input.foreach { char =>
      map.get(char) match {
        case Some(freq) => map.update(char, freq + 1)
        case None => map.put(char, 1)
      }
    }
    map
  }
}
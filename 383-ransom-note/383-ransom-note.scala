object Solution {
    def canConstruct(ransomNote: String, magazine: String): Boolean = {
      if (magazine.size < ransomNote.size) return false
      
      val freq = collection.mutable.Map.empty[Char, Int]
      magazine.foreach { char =>
        freq.get(char) match {
          case None => freq.put(char, 1)
          case Some(count) => freq.update(char, count + 1)
        }
      }
      
      ransomNote.foreach { char =>
        freq.get(char) match {
          case None => return false
          case Some(count) => freq.update(char, count - 1)
        }
      }
      
      !freq.exists(_._2 < 0)
    }
}
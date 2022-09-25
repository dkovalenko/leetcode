object Solution {
  def isAnagram(s: String, t: String): Boolean = {
    if (s.size != t. size) return false
    val freq = collection.mutable.Map.empty[Char, Int]
    
    s.foreach { char =>
      freq.get(char) match {
        case None => freq.put(char, 1)
        case Some(count) => freq.update(char, count + 1)
      }
    }
    t.foreach { char =>
      freq.get(char) match {
        case None => return false
        case Some(count) => {
          freq.update(char, count - 1)
          if (count - 1 < 0) return false
        }
      }
    }
    
    val result = freq.forall(_._2 == 0)
    
    result
  }
}
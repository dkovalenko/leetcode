object Solution {
  def longestPalindrome(s: String): Int = {
    val freq = collection.mutable.Map.empty[Char, Int]
    var result = 0
    
    s.foreach { char => 
      freq.get(char) match {
        case None => freq.put(char, 1)
        case Some(count) => {
          if (count+1 == 2) { //2 same chars for palindrome
            result += 2
            freq.remove(char)
          }
        }
      } 
    }
    
    val reminder = if (freq.isEmpty) 0 else 1
    result + reminder
  }
}
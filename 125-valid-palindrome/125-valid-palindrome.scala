object Solution {
  //"A man, a plan, a canal: Panama"
  // ^                            ^
  //"a "
  def isPalindrome(s: String): Boolean = {
    if (s.size == 1) return true
    var lIdx = 0
    var rIdx = s.size - 1 //1
    var skipChar = false
    
    while (lIdx <= rIdx) {
      skipChar = false
      val lChar = s(lIdx)
      
      if (!lChar.isLetterOrDigit) {
        lIdx += 1
        skipChar = true
      }
      
      val rChar = s(rIdx)
      if (!rChar.isLetterOrDigit) {
        rIdx -= 1
        skipChar = true
      }
      
      if(!skipChar) {
        if (lChar.toLower != rChar.toLower) {
          return false
        }
        
        lIdx += 1
        rIdx -= 1
      }
    }
    
    return true
  }
}
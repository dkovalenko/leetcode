object Solution {
  //for each char
  // - check if digit
  // - - if digit read until the end of digit
  // - - if not - check char by idx
  // - if digit end - check char by skipping digit number of chars
  
  // apple, a2e
  // internationalization, i12iz4n
  // apple, a4, a4e, a4, 5
  def validWordAbbreviation(word: String, abbr: String): Boolean = {
    var digit = 0
    var wIdx = 0
    var aIdx = 0
    
    while (wIdx < word.size) {
      // println(s"wIdx=$wIdx")
      // println(s"aIdx=$aIdx")
      if (aIdx >= abbr.size || (wIdx == word.size-1) && aIdx < abbr.size -1 ) return false
      
      if (abbr(aIdx).isDigit) {
        if (abbr(aIdx).asDigit == 0 && digit == 0) return false
        digit = if (digit == 0) abbr(aIdx).asDigit else digit * 10 + abbr(aIdx).asDigit
        if (aIdx == abbr.size-1 || !abbr(aIdx+1).isDigit) { //end or next is letter
          if (!word.isDefinedAt(wIdx + digit-1)) {
            // println("false")
            return false
          }
          
          wIdx += digit
          digit = 0
          if (wIdx >= word.size && aIdx < abbr.size -1) return false
        }
        aIdx += 1
      } else {
        if (word(wIdx) != abbr(aIdx)) {
          // println("false2")
          return false
        }
        
        wIdx += 1
        aIdx += 1
      }
    } 
      
    return true;
  }
}
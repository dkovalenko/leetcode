import collection.mutable.ArrayBuffer

object Solution {
  def reverseWords(s: String): String = {
    val arr = s.split("\\s+")

    var result = new ArrayBuffer[String](arr.size)
    for (i <- arr.size - 1 to (0, -1)) {
      if (arr(i) != "") {
        result += arr(i)
      }
    }
    
    result.mkString(" ")
  }
}
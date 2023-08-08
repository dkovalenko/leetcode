object Solution {
  def duplicateZeros(arr: Array[Int]): Unit = {
    //[1,0,2,3,0,4,5,0]
    //queue
    //[1,0,0,2,3,0,0,4]
    var firstIdx = 0
    var secondIdx = 0
    val arr2 = new Array[Int](arr.size)
    while (firstIdx < arr.size) {
      val el = arr(firstIdx)
      if (secondIdx < arr.size) {
        if (el == 0) {
          arr2(secondIdx) = 0
          if (secondIdx+1 < arr.size) {
            secondIdx += 1
            arr2(secondIdx) = 0
          }
        } else {
          arr2(secondIdx) = el
        }
      }
      
      arr(firstIdx) = arr2(firstIdx)
      firstIdx += 1
      secondIdx += 1
    }

  }
}
import collection.mutable.Set

object Solution {
  def checkIfExist(arr: Array[Int]): Boolean = {
    val freqMap = collection.mutable.Map.empty[Int, Set[Int]]
    var result = false
    for (i <- 0 until arr.size) {
      freqMap.get(arr(i)*2).map { indices => 
        // indices.filter(_ != i).headOption.foreach{_ => result = true}
        indices.headOption.foreach{_ => result = true}
      }
      if (arr(i) %2 == 0) {
        freqMap.get(arr(i)/2).map { indices => 
          // indices.filter(_ != i).headOption.foreach{_ => result = true}
          indices.headOption.foreach{_ => result = true}
        }
      }

      freqMap.get(arr(i)) match {
        case Some(set) => set += i
        case None => freqMap.put(arr(i), Set(i))
      }
    }
    result
  }
}
object Solution {
  //Input: nums = [0,0,1,1,1,2,2,3,3,4]
  //Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
  def removeDuplicates(nums: Array[Int]): Int = {
    val freqMap = collection.mutable.Map.empty[Int, Boolean]
    var p1 = 0
    var p2 = 0
    var result = 0
    while (p2 < nums.size) {
      val currentEl = nums(p2)
      if (freqMap.getOrElse(currentEl, false)) {
        p2 += 1
      } else {
        nums(p1) = currentEl
        p1 += 1
        p2 += 1
        result += 1
      }
      freqMap.put(currentEl, true)
    }

    result
  }
}
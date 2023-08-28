object Solution {
  def findDisappearedNumbers(nums: Array[Int]): List[Int] = {
    //Input: nums = [4,3,2,7,8,2,3,1]
    //Output: [5,6]
    //val freqMap = collection.mutable.Map.empty[Int, Boolean]
    val result = collection.mutable.ListBuffer.empty[Int]
    val set = nums.toSet

    for (i <- 1 to nums.size) {
      if (!set.contains(i)) {
        result += i
      }
    }
    result.toList
  }
}
import collection.mutable.ListBuffer

object Solution {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val checkMap = collection.mutable.Map.empty[Int, Int]
    for (i <- 0 until nums.size) {
      checkMap.get(target - nums(i)).foreach { idx =>
        return Array(idx, i)
      }
      checkMap(nums(i)) = i
    }
     
    Array.empty[Int]
  }
}
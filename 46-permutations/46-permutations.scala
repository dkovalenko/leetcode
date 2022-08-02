import scala.collection.mutable.ListBuffer

object Solution {
    def permute(nums: Array[Int]): List[List[Int]] = {
      val ret = ListBuffer.empty[List[Int]]
      backtrack(0, nums, ret)
      ret.toList
    }
  
  def backtrack(first: Int, nums: Array[Int], ret: ListBuffer[List[Int]]): Unit = {
    if (first == nums.size) {
      ret += nums.toList
    }
    for (i <- first until nums.size) {
      swap(nums, first, i)
      backtrack(first +1, nums, ret)
      swap(nums, first, i)
    }
  }
  
  def swap(nums: Array[Int], a: Int, b: Int): Array[Int] = {
    var tmp = nums(a)
    nums(a) = nums(b)
    nums(b) = tmp
    nums
  }
}